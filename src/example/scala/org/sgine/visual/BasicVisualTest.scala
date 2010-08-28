package org.sgine.visual

import org.sgine.core.Color
import org.sgine.visual._
import org.sgine.visual.material.pigment._
import org.sgine.visual.shape._

object BasicVisualTest {
	def main(args: Array[String]): Unit = {
		val w = Window("Simple Example")
		
		val blue = Color.Blue
		val blueMaterial = ColoredPigment(blue.subtract(alpha = 0.5f))
		val quad = new Quad(200.0f, 100.0f, blueMaterial)
		w.scene() += quad
		
		w.start()
	}
}