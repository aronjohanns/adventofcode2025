package adventofcode

import sbt.Keys.*
import sbt.*

object Dependencies {
  val Scala3 = "3.7.3"
  val ScalaVersions = Seq(Scala3)

  object Versions {
    val cats = "2.13.0"
    val catsEffect = "3.6.3"
    val fs2 = "3.12.0"
    val munit = "1.2.1"
  }

  object Compile {
    val munit = "org.scalameta" %% "munit" % Versions.munit
  }

  val impl =
    libraryDependencies ++= Seq(
    Compile.munit % Test
  )
}
