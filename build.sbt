name := "slick-example"
version := "0.1"
scalaVersion := "2.13.8"

libraryDependencies ++= List(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
)
