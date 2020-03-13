resolvers ++= Seq(
  "Artima Maven Repository" at "http://repo.artima.com/releases"
)

val nativePackagerVersion = "1.3.1"

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % nativePackagerVersion)