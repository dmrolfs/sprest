import sbt._
import Keys._

object BuildSettings {

  val VERSION = "0.1.0-SNAPSHOT"

  lazy val noPublishing = seq(
    publish := (),
    publishLocal := ()
  )

  lazy val basicSettings = seq(
    version := VERSION,
    organization := "sprest",
    description := "A suite of libraries leveraging Spray",
    startYear := Some(2013),
    licenses := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    scalaVersion := "2.10.1",
    resolvers ++= Dependencies.resolutionRepos,
    scalacOptions         := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.6",
      "-language:postfixOps",
      "-language:implicitConversions",
      "-Xlog-reflective-calls",
      "-Ywarn-adapted-args"
    )
  )

  lazy val sprestModuleSettings =
    basicSettings ++
    seq(
      version := VERSION,
      isSnapshot := true,
      publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/projects/markschaake.github.com/snapshots")))
    )
}
