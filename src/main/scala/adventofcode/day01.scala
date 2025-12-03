package adventofcode.day01
import Internal.*

type Turns = List[Int]

private object Internal {
  extension (self: Int) {
    infix def %%(other: Int): Int = Math.floorMod(self, other)
  }
  case class Dial(
      position: Int,
      zeroes: Int,
      countAndTurn: (Dial, Int) => Dial
  ) {
    def turn(amount: Int): Dial =
      countAndTurn(this, amount)
  }

  object Dial {
    def initial(countAndTurnFn: (Dial, Int) => Dial, position: Int = 50): Dial =
      Dial(position, 0, countAndTurnFn)
  }

  def fromSource(source: String): Turns = {
    source.trim
      .split('\n')
      .collect {
        case s"R$n" => n.toInt
        case s"L$n" => -n.toInt
      }
      .toList
  }

  def countZeroes(initial: Dial, turns: Turns): Int = {
    turns.foldLeft(initial)((dial, amount) => dial.turn(amount)).zeroes
  }
}

def firstPart(source: String): Int = {
  val dial = Dial.initial { (dial, amount) =>
    val newPosition = (dial.position + amount) %% 100
    dial.copy(
      position = newPosition,
      zeroes = dial.zeroes + (if (newPosition == 0) 1 else 0)
    )
  }
  countZeroes(dial, fromSource(source))
}

def secondPart(source: String): Int = {
  val dial = Dial.initial { (dial, amount) =>
    val newPosition = (dial.position + amount) %% 100

    val firstRotationPassesZero =
      newPosition == 0 ||
        amount > 0 && newPosition < dial.position ||
        amount < 0 && newPosition > dial.position && dial.position != 0

    dial.copy(
      position = newPosition,
      zeroes = dial.zeroes +
        (amount.abs / 100) +
        (if firstRotationPassesZero then 1
         else 0)
    )
  }

  countZeroes(dial, fromSource(source))
}
