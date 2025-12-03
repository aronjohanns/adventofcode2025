package adventofcode

import munit.FunSuite
import io.Source

class Day02Tests extends FunSuite {
  import day02.*
  val exampleInput = Source.fromResource("day02_example.txt").mkString
  val fullInput = Source.fromResource("day02.txt").mkString

  test("First part with example data") {
    assertEquals(BigInt(1227775554), firstPart(exampleInput))
  }

  test("First part with full data") {
    assertEquals(BigInt("30323879646"), firstPart(fullInput))
  }

  test("Second part with example data") {
    assertEquals(BigInt("4174379265"), secondPart(exampleInput))
  }

  test("Second part with full data") {
    assertEquals(BigInt("43872163557"), secondPart(fullInput))
  }
}
