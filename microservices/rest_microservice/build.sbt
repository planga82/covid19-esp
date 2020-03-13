name := "rest_microservice"
version := "0.1"

resolvers ++= Seq(
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
)

enablePlugins(JavaAppPackaging)

scalaVersion := "2.11.8"

val akkaHttpVersion = "10.1.3"
val akkaStreamsVersion = "2.5.12"
val akkaHttpJson4sVersion = "1.21.0"
val json4sVersion = "3.5.4"
val nscalaTimeVersion = "2.20.0"
val logbackVersion = "1.2.3"
val typeSafeConfVersion = "1.3.4"
val scalaLoggingVersion = "3.9.0"
val scalatestVersion = "3.0.5"
val mongodbVersion = "2.8.0"

libraryDependencies ++= Seq(
  //Akka http dependencies
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaStreamsVersion,

  //Akka-http serializer
  "de.heikoseeberger" %% "akka-http-json4s" % akkaHttpJson4sVersion,
  "org.json4s" %% "json4s-core" % json4sVersion,
  "org.json4s" %% "json4s-jackson" % json4sVersion,

  //Typesafe conf
  "com.typesafe" % "config" % typeSafeConfVersion,

  //Mongodb
  "org.mongodb.scala" %% "mongo-scala-driver" % mongodbVersion,

  //Joda wrapper
  "com.github.nscala-time" %% "nscala-time" % nscalaTimeVersion,

  //Logging
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,

  //Scala test
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",

  //Akka http test
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test"
)

maintainer in Docker := "Covid19Esp team"
packageSummary in Docker := "Rest microservice for Covid19Esp"
packageDescription := "Rest microservice for Covid19Esp"
dockerBaseImage := "openjdk:8u151"
        
