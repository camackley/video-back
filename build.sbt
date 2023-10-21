name := """video-back"""
organization := "com.camackley"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0-RC2" % Test
libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.2.0-RC1"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.43.2.1"
libraryDependencies += "com.zaxxer" % "HikariCP" % "5.0.1"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.camackley.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.camackley.binders._"
