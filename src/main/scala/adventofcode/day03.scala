package adventofcode.day03

import scala.annotation.tailrec

type Banks = List[String]

def toBanks(source: String): Banks = source.trim.split('\n').toList

def firstPart(banks: Banks) =
  banks.map { bank =>
    val left = bank.init.max
    val right = bank.drop(bank.indexOf(left) + 1).max
    s"$left$right".toInt
  }.sum

def secondPart(banks: Banks) =
  @tailrec
  def go(s: String, acc: String, budget: Int): String =
    val r = s.take(budget)
    val c = r.max
    val index = r.indexOf(c)

    if acc.length == 11 then {
      acc + s.max
    } else go(s.drop(index + 1), acc + c, budget - index)

  banks.map { bank =>
    BigInt(go(bank, "", bank.length() - 11))
  }.sum
