name := "semester-foundation-fextile"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "latest.release",
  "org.scalafx" %% "scalafx" % "8.0.60-R9",
  "com.typesafe.akka" %% "akka-slf4j" % "latest.release"
)

fork in run := true

