ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"


lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """pruebaApi2""",
    libraryDependencies ++= Seq(
      guice,
      javaJpa,
      "mysql" % "mysql-connector-java" % "8.0.29",
      "io.swagger.core.v3" % "swagger-core" % "2.0.5"
    )
  )
