name := "SprayCrud"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies  ++=  Seq(
  "org.squeryl" % "squeryl_2.11" % "0.9.5-7",
  "postgresql" % "postgresql" % "8.4-701.jdbc4",
  "io.spray" % "spray-can_2.11" % "1.3.4",
  "io.spray" % "spray-json_2.11" % "1.3.4",
  "io.spray" % "spray-routing_2.11" % "1.3.4",
  "com.typesafe.akka" % "akka-actor_2.11" % "2.5.6"
)

