name := "janalyse-ssh"

version := "0.9.20-SNAPSHOT"

jarName in assembly := "jassh.jar"

organization :="fr.janalyse"

organizationHomepage := Some(new URL("http://www.janalyse.fr"))

scalaVersion := "2.11.8"

scalacOptions ++= Seq( "-deprecation", "-unchecked", "-feature")

crossScalaVersions := Seq("2.10.6", "2.11.8")

// Mandatory as tests are also used for performances testing...
parallelExecution in Test := false

libraryDependencies ++= Seq(
    "com.jcraft"         % "jsch"               % "0.1.53"
   ,"org.apache.commons" % "commons-compress"   % "1.11"
   ,"org.slf4j"          % "slf4j-api"          % "1.7.21"
   ,"org.scalatest"     %% "scalatest"          % "2.2.6"  % "test"
   ,"com.github.scala-incubator.io" %% "scala-io-core"      % "0.4.3" % "test"
   ,"com.github.scala-incubator.io" %% "scala-io-file"      % "0.4.3" % "test"
)

initialCommands in console := """
    |import fr.janalyse.ssh._
    |import java.io.File
    |""".stripMargin

test in assembly := {}

artifactName in assembly := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
     artifact.name + "." + artifact.extension
}

