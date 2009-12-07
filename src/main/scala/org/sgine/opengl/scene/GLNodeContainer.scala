package org.sgine.opengl.scene

import org.sgine.math._
import org.sgine.scene._

/**
 * GLNodeContainer simply adds a matrix location to determine offset for child nodes
 */
class GLNodeContainer extends GeneralNodeContainer {
	val location = new Matrix4()
}