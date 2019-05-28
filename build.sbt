
lazy val app = project
  .settings(
    organization := "com.github.alexarchambault.test",
    version := "0.1.0",
    scalaVersion := "2.12.8",
    crossPaths := false,
    publishTo := Some("gh-release-packages" at "https://maven.pkg.github.com/alexarchambault"),
    homepage := Some(url("https://github.com/alexarchambault/test-gh-package-registry-scala-sbt")),
    licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    scmInfo := Some(ScmInfo(url("https://github.com/alexarchambault/test-gh-package-registry-scala-sbt"), "scm:git:git@github.com:alexarchambault/test-gh-package-registry-scala-sbt.git")),
    credentials ++= {
      (sys.env.get("GH_USERNAME"), sys.env.get("GH_TOKEN")) match {
        case (Some(user), Some(pass)) =>
	  Seq(Credentials("GitHub Package Registry", "maven.pkg.github.com", user, pass))
	case _ => Nil
      }
    }
  )

skip.in(publish) := true
