package adventofcode

import munit.FunSuite
import scala.io.Source

class Day01Spec extends FunSuite {
  import Day01.*
  val smallInput = """
L68
L30
R48
L5
R60
L55
L1
L99
R14
L82
  """

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
