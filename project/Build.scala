import sbt.Keys._
import sbt._

object Build extends sbt.Build with Dependencies {
  name := "scak"
  version := "1.0"
  scalaVersion := "2.10.4"

  val core = Project("scak-core", file("core"),
    settings = defaultSettings ++ Seq(
      libraryDependencies ++= jettyDependencies ++
        logbackDependencies ++
        jacksonDependencies
    )
  )


  val example = Project("scak-example", file("example"),
    settings = defaultSettings ++ Seq()
  ).dependsOn(core)


  def defaultSettings = net.virtualvoid.sbt.graph.Plugin.graphSettings ++ Seq(
    parallelExecution in Compile := false
  )
}