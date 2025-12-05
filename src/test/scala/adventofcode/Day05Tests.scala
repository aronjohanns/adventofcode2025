package adventofcode

import munit.FunSuite

import scala.io.Source

class Day05Tests extends FunSuite {
  import day05.*

  val example = Source.fromResource("day05_example.txt").mkString
  val full = Source.fromResource("day05.txt").mkString

  test("First part using example input") {
    val result = firstPart(example)
    assertEquals(3, result)
  }
  test("First part using full input") {
    val result = firstPart(full)
    assertEquals(712, result)
  }
  test("Second part using example input") {
    val result = secondPart(example)
    assertEquals(BigInt(14), result)

  }
  test("Second part using full input") {
    val result = secondPart(full)
    assertEquals(BigInt("332998283036769"), result)
  }
}
