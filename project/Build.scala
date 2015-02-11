import sbt._
import Keys._
import scoverage._

object Setting {
  val common: Seq[Setting[_]] = Seq(
    organization := "com.example",
    scalaVersion := "2.11.5",
    libraryDependencies ++= Dependency.common,
    javaOptions ++= Seq("-Xmx2G", "-Xms1G", "-XX:+CMSClassUnloadingEnabled"),
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint"),
    scalacOptions ++= Seq("-deprecation", "-feature", "-language:reflectiveCalls"),
    ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "<empty>;Reverse.*;.*?javascript;controllers.debug.*?",
    ScoverageSbtPlugin.ScoverageKeys.coverageExcludedFiles := "*routing.scala;"
  )

  val asset = common ++ Seq(
    resolvers ++= Resolver.common,
    libraryDependencies ++= Dependency.asset,
    javaOptions in Test ++= Seq("-Dconfig.file=../../conf/application.conf")
  )
  val infrastructure = common ++ Seq(
    resolvers ++= Resolver.infrastructure,
    libraryDependencies ++= Dependency.infrastructure,
    javaOptions in Test ++= Seq("-Dconfig.file=../../conf/application.conf")
  )
  val domain = common ++ Seq(
    resolvers ++= Resolver.domain,
    libraryDependencies ++= Dependency.domain,
    javaOptions in Test ++= Seq("-Dconfig.file=../../conf/application.conf")
  )
  val application = common ++ Seq(
    resolvers ++= Resolver.application,
    libraryDependencies ++= Dependency.application,
    javaOptions in Test ++= Seq("-Dconfig.file=../../conf/application.conf")
  )
  val main = common ++ Seq(
    resolvers ++= Resolver.main,
    libraryDependencies ++= Dependency.main
  )
}

object Dependency {
  val common = Seq()

  val asset = common ++ Seq()
  val infrastructure = common ++ Seq()
  val domain = common ++ Seq()
  val application = common ++ Seq()
  val main = common ++ Seq()
}

object Resolver {
  val common = Seq()

  val asset = common ++ Seq()
  val infrastructure = common ++ Seq()
  val domain = common ++ Seq()
  val application = common ++ Seq()
  val main = common ++ Seq()
}
