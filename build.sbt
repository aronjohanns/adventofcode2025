import adventofcode.Dependencies

ThisBuild / scalaVersion := Dependencies.Scala3

lazy val root = (project in file("."))
  .settings(Dependencies.impl)
