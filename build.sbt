/** *****************************************/
/** ********* PROJECT INFO ******************/
/** *****************************************/
name := "finder-kata"
version := "1.0-SNAPSHOT"

/** *********************************************/
/** ********* PROJECT SETTINGS ******************/
/** *********************************************/
Configuration.settings

/** *********************************************/
/** ********* PROD DEPENDENCIES *****************/
/** *********************************************/
libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "2.30.0",
  "com.lihaoyi" %% "pprint" % "0.7.3"
)

/** *********************************************/
/** ********* TEST DEPENDENCIES *****************/
/** *********************************************/
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.11" % Test,
//  "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test
)

/** *********************************************/
/** ********* COMMANDS ALIASES ******************/
/** *********************************************/
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("s", "scalastyle")
addCommandAlias("ts", "test:scalastyle")
