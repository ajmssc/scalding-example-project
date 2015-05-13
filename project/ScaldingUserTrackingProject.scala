import sbt._
import Keys._

object ScaldingUserTrackingProject extends Build {

  import Dependencies._
  import BuildSettings._

  // Configure prompt to show current project
  override lazy val settings = super.settings :+ {
    shellPrompt := { s => Project.extract(s).currentProject.id + " > " }
  }

  // Define our project, with basic project information and library dependencies
  lazy val project = Project("scalding-example-project", file("."))
    .settings(buildSettings: _*)
    .settings(
      libraryDependencies ++= Seq(
        Libraries.scaldingCore,
        Libraries.scaldingAvro,
        Libraries.hadoopCore,
        Libraries.specs2,
        Libraries.avroSchemas
        // Add your additional libraries here (comma-separated)...
      )
    )
}
