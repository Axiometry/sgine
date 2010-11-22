package org.sgine.render

import simplex3d.math.doublem.renamed._
import simplex3d.math.doublem.DoubleMath._

import javax.imageio._

import org.lwjgl.opengl.GL11._

import org.sgine.core.Color

import org.sgine.render.shape.Quad

object TestQuad {
	def main(args: Array[String]): Unit = {
		val r = Renderer.createFrame(1024, 768, "Test Quad")
		r.verticalSync := false
		
		val t = TextureUtil(ImageIO.read(getClass.getClassLoader.getResource("puppies.jpg")))
		
		val m = Mat3x4 translate(Vec3(0, 0, -800.0))
		val quad = Quad.subtexture(t, 0.0, 0.0, t.width, t.height, 0.5)
		val fps = FPS(1.0)
		
		r.renderable := RenderList(MatrixState(m), () => t.bind(), quad, fps)
	}
}