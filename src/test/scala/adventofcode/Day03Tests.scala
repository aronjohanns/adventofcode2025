package adventofcode

import munit.FunSuite
import scala.io.Source

class Day03Tests extends FunSuite {
  import day03.*

  val example = Source.fromResource("day03_example.txt").mkString
  val full = Source.fromResource("day03.txt").mkString

  test("First part using example input") {
    val result = firstPart(toBanks(example))
    assertEquals(357, result)
  }

  test("First part using full input") {
    val result = firstPart(toBanks(full))
    assertEquals(17432, result)
  }

  test("Second part using example input") {
    val result = secondPart(toBanks(example))
    assertEquals(BigInt("3121910778619"), result)
  }
  test("Second part using full input") {
    val result = secondPart(toBanks(full))
    assertEquals(BigInt("173065202451341"), result)
  }
}
