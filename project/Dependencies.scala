import sbt._

trait Dependencies {
  // Version Numbers ------------------------------------
  val versions = Map(
    'jetty -> "9.0.7.v20131107",
    'slf4j -> "1.7.7",
    'jackson -> "2.4.2"
  )

  // -----------------------
  val jettyDependencies = Seq(
    "org.eclipse.jetty" % "jetty-server" % versions('jetty)
  )

  val jacksonDependencies = Seq(
    "com.fasterxml.jackson.core" % "jackson-core" % versions('jackson),
    "com.fasterxml.jackson.core" % "jackson-databind" % versions('jackson),
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.4.2"

  )

  val logbackDependencies = Seq(
    "ch.qos.logback" % "logback-classic" % "1.1.2" exclude("org.slf4j", "slf4j-api"),
    "org.slf4j" % "slf4j-api" % versions('slf4j),
    "org.slf4j" % "jul-to-slf4j" % versions('slf4j),
    "org.slf4j" % "jcl-over-slf4j" % versions('slf4j),
    "org.slf4j" % "log4j-over-slf4j" % versions('slf4j)
  )

}