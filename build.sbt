import adventofcode.Dependencies

ThisBuild / scalaVersion := Dependencies.Scala3
// Compile / compile / wartremoverErrors ++= Warts.all
// Test / wartremoverErrors := Seq.empty

lazy val root = (project in file("."))
  .settings(Dependencies.impl)
