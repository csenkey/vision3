name := """vision"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,

  javaCore
)

routesGenerator := InjectedRoutesGenerator


lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

lazy val nonEnhancedProject = (project in file("non-enhanced"))
  .disablePlugins(PlayEnhancer)