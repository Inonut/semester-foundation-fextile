name := "semester-foundation-fextile"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.60-R9",
  "com.typesafe.akka" %% "akka-actor" % "latest.release",

  "org.scala-lang.modules" % "scala-async_2.11" % "0.9.6-RC2"
)

fork in run := true

