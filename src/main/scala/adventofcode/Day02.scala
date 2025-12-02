package adventofcode.day02

import scala.collection.immutable.NumericRange.Inclusive

private def toRanges(source: String): List[Inclusive[BigInt]] = {
  source.trim
    .split(',')
    .collect { case s"$low-$high" =>
      BigInt(low) to BigInt(high)
    }
    .toList
}

def firstPart(source: String): BigInt = {
  toRanges(source).foldLeft(BigInt(0)) { (acc, range) =>
    acc + range
      .map(_.toString)
      .filter { id =>
        val (first, second) = id.splitAt(id.length() / 2)
        first == second
      }
      .map(BigInt(_))
      .sum
  }
}

def secondPart(source: String): BigInt = {
  toRanges(source).foldLeft(BigInt(0)) { (acc, range) =>
    acc + range
      .map(_.toString)
      .filter { id =>
        (1 to id.length / 2)
          .map(n => id.take(n) * (id.length / n))
          .filter(_ == id)
          .nonEmpty
      }
      .map(BigInt(_))
      .sum
  }
}
