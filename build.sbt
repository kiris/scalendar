organization := "com.github.philcali"

name := "scalendar"

version := "0.1.5"

scalaVersion := "2.12.1"

crossScalaVersions := Seq (
  "2.12.1",
  "2.11.8", "2.11.0",
  "2.10.3"
)

def isSvHigh(sv: String): Boolean = {
  (sv startsWith "2.11") || (sv startsWith "2.12")
}

scalacOptions <++= scalaVersion map {
  case sv if isSvHigh(sv) =>
    Seq("-feature", "-language:implicitConversions")
  case _ => Nil
}

libraryDependencies <++= scalaVersion {
  case sv if isSvHigh(sv) => Seq(
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "test",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test")
  case _ =>
    Seq("org.scalatest" %% "scalatest" % "3.0.1" % "test")
}

publishTo := Some(Resolver.file("file", file("repo")))