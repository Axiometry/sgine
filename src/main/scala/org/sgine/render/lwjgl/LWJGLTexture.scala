package org.sgine.render.lwjgl

import java.nio.ByteBuffer
import java.nio.IntBuffer

import org.lwjgl.opengl.GL11._
import org.lwjgl.opengl.GL12._
import org.lwjgl.opengl.GL14._
import org.sgine.opengl.GLUtilities._

class LWJGLTexture private[lwjgl](var tu: TextureUpdate) {
	lazy val id = generateId()
	
	private var x: Int = _
	private var y: Int = _
	private var width: Int = _
	private var height: Int = _
	private var imageFormat: Int = _
	private var mipmap: Boolean = _
	
	private def generateId() = {
		val tmp = IntBuffer.allocate(1)
		glGenTextures(tmp)
		tmp.get(0)
	}
	
	def bind() = {
		glBindTexture(GL_TEXTURE_2D, id)
		
		if (tu != null) {
			updateTexture()
		}
		
		glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE)
		
		var w: Float = width
		var h: Float = height
		if (!isNPOT) {
			w = nextPOT(width)
			h = nextPOT(height)
		}
		w = w / 2.0f
		h = h / 2.0f
	}
	
	private def updateTexture() = {
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR)
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, if (tu.mipmap) GL_LINEAR_MIPMAP_LINEAR else GL_LINEAR);
		if (isVersion12) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		}
		if ((tu.mipmap) && (isMipmap)) {
			glTexParameteri(GL_TEXTURE_2D, GL_GENERATE_MIPMAP, GL_TRUE);
		}
		if ((tu.width != width) || (tu.height != height) || (tu.imageFormat != imageFormat) || (tu.mipmap != mipmap)) {
			var w = tu.width;
			var h = tu.height;
			if (isNPOT) {
				x = 0;
				y = 0;
			} else {
				w = nextPOT(w);
				h = nextPOT(h);
				x = Math.round((w - tu.width) / 2.0f);
				y = Math.round((h - tu.height) / 2.0f);
			}
			glTexImage2D(GL_TEXTURE_2D, 0, tu.imageFormat, w, h, 0, tu.textureFormat, tu.imageType, null.asInstanceOf[ByteBuffer]);
			
			width = tu.width;
			height = tu.height;
			imageFormat = tu.imageFormat;
			mipmap = tu.mipmap;
		}
		glTexSubImage2D(GL_TEXTURE_2D, 0, x, y, tu.width, tu.height, tu.textureFormat, tu.imageType, tu.buffer);
		if ((tu.mipmap) && (!isMipmap)) {
			println("**** TODO: implement glu mipmap generation ****");		// TODO: implement
		}
	}
	
	private def nextPOT(value:Int) = {
		var ret = 1
		while (ret < value) {
			ret <<= 1
		}
		ret
	}
}

case class TextureUpdate(buffer: ByteBuffer, width: Int, height: Int, textureFormat: Int, imageFormat: Int, imageType: Int, mipmap: Boolean)