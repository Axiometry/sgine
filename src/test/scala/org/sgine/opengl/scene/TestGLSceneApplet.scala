package org.sgine.opengl.scene

import org.sgine.easing._
import org.sgine.opengl._
import org.sgine.opengl.scene._
import org.sgine.opengl.shape._
import org.sgine.property._
import org.sgine.property.adjust._

import javax.imageio._

class TestGLSceneApplet extends GLApplet {
	override def begin() = {
		// Create a container for our scene
		val root = new GLNodeContainer()
		val node = new GLShape()
		root.rotation.z.adjuster = new EasingNumericAdjuster(Linear.easeOut, 10.0)
		root.rotation.z := 3.0
		node.location.z := -1000.0
		node.location.z.adjuster = new EasingNumericAdjuster(Bounce.easeOut, 5.0)
		node.location.z := -2000.0
		root += node
		val shape = Shape(ImageIO.read(classOf[GLWindow].getClassLoader().getResource("resource/puppies.jpg")))
		node.shape := shape
		
		val renderer = new GLSceneRenderer(root)
		displayables.add(renderer)
		
		displayables.add(FPS())
		
		super.begin()
		
		node.location.z.waitForTarget()
		node.location.z := -500.0
		node.location.z.waitForTarget()
	}
}
