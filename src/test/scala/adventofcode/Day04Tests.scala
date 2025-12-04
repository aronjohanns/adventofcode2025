package adventofcode

import munit.FunSuite

import scala.io.Source

class Day04Tests extends FunSuite {
  import day04.*

  val example = Source.fromResource("day04_example.txt").mkString
  val full = Source.fromResource("day04.txt").mkString

  test("First part using example input") {
    val result = firstPart(Grid.fromSource(example))
    assertEquals(13, result)
  }

  test("First part using full input") {
    val result = firstPart(Grid.fromSource(full))
    assertEquals(1626, result)
  }

  test("Second part using example input") {
    val result = secondPart(Grid.fromSource(example))
    assertEquals(43, result)
  }
  test("Second part using full input") {
    val result = secondPart(Grid.fromSource(full))
    assertEquals(9173, result)
  }
}
