name := """multi-project-sample"""

version := "1.0-SNAPSHOT"

lazy val asset = (project in file("modules/asset"))
  .enablePlugins(PlayScala)

lazy val infrastructure = (project in file("modules/infrastructure"))
  .enablePlugins(PlayScala)

lazy val domain = (project in file("modules/domain"))
  .enablePlugins(PlayScala)
  .dependsOn(infrastructure)

lazy val application = (project in file("modules/application"))
  .enablePlugins(PlayScala)
  .dependsOn(infrastructure, domain)

lazy val main = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(asset, infrastructure, domain, application)
  .aggregate(asset, infrastructure, domain, application)

Setting.main


