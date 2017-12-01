package hello

import java.io.File
import org.apache.catalina.WebResourceRoot
import org.apache.catalina.core.StandardContext
import org.apache.catalina.startup.Tomcat
import org.apache.catalina.webresources.DirResourceSet
import org.apache.catalina.webresources.StandardRoot

fun main(args: Array<String>) {
	val tomcat = Tomcat()
	val webappDirLocation = "src/main/webapp/"
	val webPort = "8080"
	tomcat.setPort(Integer.valueOf(webPort))
	val ctx = tomcat.addWebapp("", File(webappDirLocation).absolutePath) as StandardContext
	val additionWebInfClasses = File("target/classes")
	val resources = StandardRoot(ctx)
	resources.addPreResources(DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.absolutePath, "/"))
	ctx.resources = resources
	tomcat.start()
	tomcat.server.await()
}

