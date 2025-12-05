package adventofcode.day05

case class Inclusive(start: BigInt, end: BigInt):
  def contains(v: BigInt): Boolean =
    start <= v && v <= end

def input(source: String): (List[Inclusive], List[BigInt]) =
  val (before, after) = source.trim.split('\n').toList.span(!_.isBlank)

  (
    before.collect:
      case s"$low-$high" => Inclusive(BigInt(low), BigInt(high))
    ,
    after.tail.map(BigInt(_))
  )

def mergeRanges(ranges: List[Inclusive]): List[Inclusive] =
  ranges
    .sortWith((a, b) => a.start <= b.start)
    .foldLeft(List.empty[Inclusive]):
      case (Nil, cur)                                 => cur :: Nil
      case (r1 :: rest, r2) if r2.start <= r1.end + 1 =>
        Inclusive(r1.start, r1.end.max(r2.end)) :: rest
      case (acc, cur) => cur :: acc
    .reverse

def firstPart(source: String): Int =
  val (inv, ids) = input(source)
  val merged = mergeRanges((inv))
  ids.filter(id => merged.exists(_.contains(id))).length

def secondPart(source: String): BigInt =
  val (inv, ids) = input(source)
  val merged = mergeRanges((inv))
  merged.map(r => r.end - (r.start - 1)).sum
