package org.sgine.render.shape

import org.sgine.core.Enumeration
import org.sgine.core.Enumerated

import org.lwjgl.opengl.GL11._

sealed class ShapeMode(val value: Int) extends Enumeration

object ShapeMode extends Enumerated[ShapeMode] {
	case object Quads extends ShapeMode(GL_QUADS)
	case object Triangles extends ShapeMode(GL_TRIANGLES)
	
	ShapeMode(Quads, Triangles)
}