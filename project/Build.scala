import sbt.Keys._
import sbt._

object Build extends sbt.Build {
  name := "scak"
  version := "1.0"
  scalaVersion := "2.10.4"

  lazy val core = Project("core", file("core"),
    settings = net.virtualvoid.sbt.graph.Plugin.graphSettings ++ Seq(
      libraryDependencies ++= Seq(
        "org.eclipse.jetty" % "jetty-server" % "9.0.7.v20131107"
      )
    )
  )
}