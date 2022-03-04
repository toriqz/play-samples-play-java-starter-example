lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """play-java-starter-example""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.6",
    scalacOptions += "-target:jvm-1.8",
    libraryDependencies ++= Seq(
      guice,
      // Test Database
      "com.h2database" % "h2" % "1.4.199",
      // Testing libraries for dealing with CompletionStage...
      "org.assertj" % "assertj-core" % "3.14.0" % Test,
      "org.awaitility" % "awaitility" % "4.0.1" % Test,
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror",
      "-source", "1.8", "-target", "1.8"
    ),
    // Make verbose tests
    testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v")),
    // Java project. Don't expect Scala IDE
    EclipseKeys.projectFlavor := EclipseProjectFlavor.Java,

    // Use .class files instead of generated .scala files for views and routes
    EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)
  )
