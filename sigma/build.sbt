organization := "cz.cvut.fit.sigma"

name := "ttc16-cra-sigma"

version := "1.0"

scalaVersion := "2.11.8"

com.github.retronym.SbtOneJar.oneJarSettings

resolvers += "SIGMA repository" at "https://dl.dropboxusercontent.com/u/4168936/mvn-repo"

scalacOptions ++= Seq("-Xlint", "-feature", "-deprecation", "-unchecked")

unmanagedSourceDirectories in Compile += baseDirectory.value / "src-gen/main/scala"

unmanagedSourceDirectories in Compile += baseDirectory.value / "src-gen/main/java"

libraryDependencies += "org.moeaframework" % "moeaframework" % "2.10"

libraryDependencies += "fr.unice.i3s.sigma" %% "sigma-core" % "1.0.0-SNAPSHOT"

libraryDependencies += "fr.unice.i3s.sigma" %% "sigma-emf" % "1.0.0-SNAPSHOT"

libraryDependencies += "fr.unice.i3s.sigma" %% "sigma-emf-tools" % "1.0.0-SNAPSHOT"

libraryDependencies += "org.eclipse.emf" % "org.eclipse.emf.ecore.xmi" % "2.9.1-v20130827-0309"

libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1"

mainClass in Compile := Some("cz.cvut.fit.sigma.ttc16.cra.Main")