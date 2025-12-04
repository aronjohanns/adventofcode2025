package adventofcode.day04

import scala.annotation.tailrec

import Grid.*

type Grid = Vector[Vector[Char]]

object Grid:
  def fromSource(source: String): Grid =
    source.trim.split('\n').toVector.map(_.toVector)

  val adjacancyIndexes = List(
    (-1, -1), // NW
    (-1, 0), // N
    (-1, 1), // NE
    (0, -1), // W
    (0, 1), // E
    (1, -1), // SW
    (1, 0), // S
    (1, 1) // SE
  )

  extension (self: Grid)
    def adjacentColsAt(pos: (row: Int, col: Int)): List[Option[Char]] =
      adjacancyIndexes
        .map(idx => (idx._1 + pos.row, idx._2 + pos.col))
        .map: (row, col) =>
          self.lift(row).flatMap(_.lift(col))

    def canClear(pos: (row: Int, col: Int)): Boolean =
      self
        .adjacentColsAt(pos)
        .map:
          case Some('@') => 1
          case _         => 0
        .sum < 4

    def clearGrid: (grid: Grid, nCleared: Int) =
      self.zipWithIndex.foldLeft((Vector.empty[Vector[Char]], 0)):
        case ((grid1, acc), (row, ri)) =>
          val (row1, nCleared) =
            row.zipWithIndex.foldLeft(Vector.empty[Char], 0):
              case ((row1, acc), (col, ci)) =>
                (col, ci) match
                  case ('.', _)  => (row1 :+ '.', acc)
                  case (col, ci) =>
                    if self.canClear(ri, ci) then (row1 :+ '.', acc + 1)
                    else (row1 :+ col, acc)
          (grid1 :+ row1, acc + nCleared)

def firstPart(grid: Grid): Int =
  grid.clearGrid.nCleared

def secondPart(grid: Grid): Int =
  @tailrec
  def go(grid: Grid, acc: Int): Int =
    val (grid1, cleared) = grid.clearGrid
    if cleared == 0 then acc else go(grid1, acc + cleared)

  go(grid, 0)
