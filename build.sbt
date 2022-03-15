ThisBuild / scalaVersion := "3.1.1"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.8"
val JDBCVersion = "7.0.0-M2"
val SlickVersion = "3.4.0-M1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor-typed_2.13" % AkkaVersion,
  "com.typesafe.akka" % "akka-stream_2.13" % AkkaVersion,
  "com.typesafe.akka" % "akka-http_2.13" % AkkaHttpVersion,
  "com.typesafe.slick" % "slick_2.13" % SlickVersion,
  "com.typesafe.slick" % "slick-hikaricp_2.13" % SlickVersion,
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)


lazy val app = (project in file("."))
    .enablePlugins(JavaAppPackaging)
    .settings(
        mainClass := Some("main"),
    )