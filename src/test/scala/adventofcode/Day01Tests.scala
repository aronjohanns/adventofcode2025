package adventofcode

import munit.FunSuite
import scala.io.Source

class Day01Tests extends FunSuite {
  import day01.*

  val smallInput = Source.fromResource("day01_example.txt").mkString
  val fullInput = Source.fromResource("day01.txt").mkString

  test("First part with example input") {
    assertEquals(3, firstPart(smallInput))
  }

  test("First part with full input") {
    assertEquals(1177, firstPart(fullInput))
  }

  test("Second part with example input") {
    assertEquals(6, secondPart(smallInput))
  }

  test("Second part with full input") {
    assertEquals(6768, secondPart(fullInput))
  }
}
