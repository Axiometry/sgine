import java.io.File

import sbt._

class SgineProject(info: ProjectInfo) extends DefaultProject(info) {
	override def testSourceRoots = super.testSourceRoots +++ ("src" / "example")
	override def runClasspath = super.runClasspath +++ testClasspath +++ ("src" / "main" / "resources") +++ ("src" / "test" / "resources") +++ ("src" / "example" / "resources")

	lazy val exampleSourcePath: Path = ("src" / "example")
	def exampleResourcesPath = exampleSourcePath / resourcesDirectoryName
	def exampleResources = descendents(exampleResourcesPath ##, "*")
	
	override def packageTestPaths = super.packageTestPaths +++ exampleResources
	
	lazy val runExample = task {
		args => runTask(Some(args(0)), runClasspath).dependsOn(testCompile)
	} completeWith(mainSources.getRelativePaths.toSeq.map(_.replace("/", ".").replace(".scala", "")))
	
	lazy val runExampleVerbose = createRunExampleVerbose()
	
	private def createRunExampleVerbose() = {
		verbose = true
		task {
			args => runTask(Some(args(0)), runClasspath).dependsOn(testCompile)
		} completeWith(mainSources.getRelativePaths.toSeq.map(_.replace("/", ".").replace(".scala", "")))
	}
	
	private var verbose = false
	
	override def compileOptions = super.compileOptions ++ Seq(Deprecation, Unchecked, Optimize)
	
	override def fork = Some(new ForkScalaRun {
		val (os, separator) = System.getProperty("os.name").split(" ")(0).toLowerCase match {
            case "linux" => "linux" -> ":"
            case "mac" => "macosx" -> ":"
            case "windows" => "windows" -> ";"
            case "sunos" => "solaris" -> ":"
            case x => x -> ":"
        }
        
        override def runJVMOptions = {
        	var options = super.runJVMOptions ++ Seq("-server",
        											 "-Djava.library.path=" + System.getProperty("java.library.path") + separator + ("lib" / "native" / os),
        											 "-XX:+ExplicitGCInvokesConcurrent",
        											 "-XX:+UseConcMarkSweepGC",
        											 "-XX:+DoEscapeAnalysis",
        											 "-XX:+UseCompressedOops"
        											 )
        	if (verbose) {
        		options = options ++ Seq("-verbose:gc")
        	}
        	options
        }
        
        override def scalaJars = Seq(buildLibraryJar.asFile, buildCompilerJar.asFile)
	})
}