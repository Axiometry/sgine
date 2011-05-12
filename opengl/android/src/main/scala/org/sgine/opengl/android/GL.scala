/*
 * Copyright (c) 2011 Sgine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *  Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 *  Neither the name of 'Sgine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sgine.opengl.android

/**
 * Generated by org.sgine.opengl.generator.OpenGLGenerator
 *
 * Documentation information pulled from <a href="http://www.opengl.org/sdk/docs/man/">http://www.opengl.org/sdk/docs/man/</a>.
 *
 * @see org.sgine.opengl.generator.OpenGLGenerator
 */
class GL(instance: javax.microedition.khronos.opengles.GL11) extends org.sgine.opengl.GL {
	def glViewport(x: Int, y: Int, width: Int, height: Int): Unit = {
		instance.glViewport(x, y, width, height)
	}

	def glVertexPointer(size: Int, `type`: Int, stride: Int, pointer: java.nio.Buffer): Unit = {
		instance.glVertexPointer(size, `type`, stride, pointer)
	}

	def glVertexPointer(size: Int, `type`: Int, stride: Int, offset: Int): Unit = {
		instance.glVertexPointer(size, `type`, stride, offset)
	}

	def glTranslatex(x: Int, y: Int, z: Int): Unit = {
		instance.glTranslatex(x, y, z)
	}

	def glTranslatef(x: Float, y: Float, z: Float): Unit = {
		instance.glTranslatef(x, y, z)
	}

	def glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, width: Int, height: Int, format: Int, `type`: Int, pixels: java.nio.Buffer): Unit = {
		instance.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, `type`, pixels)
	}

	def glTexParameterfv(target: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glTexParameterfv(target, pname, params)
	}

	def glTexParameteriv(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glTexParameteriv(target, pname, params)
	}

	def glTexParameterx(target: Int, pname: Int, param: Int): Unit = {
		instance.glTexParameterx(target, pname, param)
	}

	def glTexParameterxv(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glTexParameterxv(target, pname, params)
	}

	def glTexParameterf(target: Int, pname: Int, param: Float): Unit = {
		instance.glTexParameterf(target, pname, param)
	}

	def glTexParameteri(target: Int, pname: Int, param: Int): Unit = {
		instance.glTexParameteri(target, pname, param)
	}

	def glTexImage2D(target: Int, level: Int, internalformat: Int, width: Int, height: Int, border: Int, format: Int, `type`: Int, pixels: java.nio.Buffer): Unit = {
		instance.glTexImage2D(target, level, internalformat, width, height, border, format, `type`, pixels)
	}

	def glTexEnvfv(target: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glTexEnvfv(target, pname, params)
	}

	def glTexEnvxv(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glTexEnvxv(target, pname, params)
	}

	def glTexEnvf(target: Int, pname: Int, param: Float): Unit = {
		instance.glTexEnvf(target, pname, param)
	}

	def glTexEnvi(target: Int, pname: Int, param: Int): Unit = {
		instance.glTexEnvi(target, pname, param)
	}

	def glTexCoordPointer(size: Int, `type`: Int, stride: Int, pointer: java.nio.Buffer): Unit = {
		instance.glTexCoordPointer(size, `type`, stride, pointer)
	}

	def glTexCoordPointer(size: Int, `type`: Int, stride: Int, offset: Int): Unit = {
		instance.glTexCoordPointer(size, `type`, stride, offset)
	}

	def glStencilOp(fail: Int, zfail: Int, zpass: Int): Unit = {
		instance.glStencilOp(fail, zfail, zpass)
	}

	def glStencilMask(mask: Int): Unit = {
		instance.glStencilMask(mask)
	}

	def glStencilFunc(func: Int, ref: Int, mask: Int): Unit = {
		instance.glStencilFunc(func, ref, mask)
	}

	def glShadeModel(mode: Int): Unit = {
		instance.glShadeModel(mode)
	}

	def glScissor(x: Int, y: Int, width: Int, height: Int): Unit = {
		instance.glScissor(x, y, width, height)
	}

	def glScalex(x: Int, y: Int, z: Int): Unit = {
		instance.glScalex(x, y, z)
	}

	def glScalef(x: Float, y: Float, z: Float): Unit = {
		instance.glScalef(x, y, z)
	}

	def glSampleCoverage(value: Float, invert: Boolean): Unit = {
		instance.glSampleCoverage(value, invert)
	}

	def glRotatef(angle: Float, x: Float, y: Float, z: Float): Unit = {
		instance.glRotatef(angle, x, y, z)
	}

	def glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, `type`: Int, pixels: java.nio.Buffer): Unit = {
		instance.glReadPixels(x, y, width, height, format, `type`, pixels)
	}

	def glPushMatrix(): Unit = {
		instance.glPushMatrix()
	}

	def glPopMatrix(): Unit = {
		instance.glPopMatrix()
	}

	def glPolygonOffset(factor: Float, units: Float): Unit = {
		instance.glPolygonOffset(factor, units)
	}

	def glPointSize(size: Float): Unit = {
		instance.glPointSize(size)
	}

	def glPointParameterfv(pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glPointParameterfv(pname, params)
	}

	def glPointParameterx(pname: Int, param: Int): Unit = {
		instance.glPointParameterx(pname, param)
	}

	def glPointParameterxv(pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glPointParameterxv(pname, params)
	}

	def glPointParameterf(pname: Int, param: Float): Unit = {
		instance.glPointParameterf(pname, param)
	}

	def glPixelStorei(pname: Int, param: Int): Unit = {
		instance.glPixelStorei(pname, param)
	}

	def glOrthox(left: Int, right: Int, bottom: Int, top: Int, zNear: Int, zFar: Int): Unit = {
		instance.glOrthox(left, right, bottom, top, zNear, zFar)
	}

	def glNormalPointer(`type`: Int, stride: Int, pointer: java.nio.Buffer): Unit = {
		instance.glNormalPointer(`type`, stride, pointer)
	}

	def glNormalPointer(`type`: Int, stride: Int, offset: Int): Unit = {
		instance.glNormalPointer(`type`, stride, offset)
	}

	def glNormal3x(nx: Int, ny: Int, nz: Int): Unit = {
		instance.glNormal3x(nx, ny, nz)
	}

	def glNormal3f(nx: Float, ny: Float, nz: Float): Unit = {
		instance.glNormal3f(nx, ny, nz)
	}

	def glMultiTexCoord4x(target: Int, s: Int, t: Int, r: Int, q: Int): Unit = {
		instance.glMultiTexCoord4x(target, s, t, r, q)
	}

	def glMultiTexCoord4f(target: Int, s: Float, t: Float, r: Float, q: Float): Unit = {
		instance.glMultiTexCoord4f(target, s, t, r, q)
	}

	def glMultMatrixf(m: java.nio.FloatBuffer): Unit = {
		instance.glMultMatrixf(m)
	}

	def glMatrixMode(mode: Int): Unit = {
		instance.glMatrixMode(mode)
	}

	def glMaterialfv(face: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glMaterialfv(face, pname, params)
	}

	def glMaterialx(face: Int, pname: Int, param: Int): Unit = {
		instance.glMaterialx(face, pname, param)
	}

	def glMaterialxv(face: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glMaterialxv(face, pname, params)
	}

	def glMaterialf(face: Int, pname: Int, param: Float): Unit = {
		instance.glMaterialf(face, pname, param)
	}

	def glLogicOp(opcode: Int): Unit = {
		instance.glLogicOp(opcode)
	}

	def glLoadMatrixf(m: java.nio.FloatBuffer): Unit = {
		instance.glLoadMatrixf(m)
	}

	def glLoadIdentity(): Unit = {
		instance.glLoadIdentity()
	}

	def glLineWidth(width: Float): Unit = {
		instance.glLineWidth(width)
	}

	def glLightModelfv(pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glLightModelfv(pname, params)
	}

	def glLightModelx(pname: Int, param: Int): Unit = {
		instance.glLightModelx(pname, param)
	}

	def glLightModelxv(pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glLightModelxv(pname, params)
	}

	def glLightModelf(pname: Int, param: Float): Unit = {
		instance.glLightModelf(pname, param)
	}

	def glLightfv(light: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glLightfv(light, pname, params)
	}

	def glLightx(light: Int, pname: Int, param: Int): Unit = {
		instance.glLightx(light, pname, param)
	}

	def glLightxv(light: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glLightxv(light, pname, params)
	}

	def glLightf(light: Int, pname: Int, param: Float): Unit = {
		instance.glLightf(light, pname, param)
	}

	def glIsTexture(texture: Int): Boolean = {
		instance.glIsTexture(texture)
	}

	def glIsEnabled(cap: Int): Boolean = {
		instance.glIsEnabled(cap)
	}

	def glIsBuffer(buffer: Int): Boolean = {
		instance.glIsBuffer(buffer)
	}

	def glHint(target: Int, mode: Int): Unit = {
		instance.glHint(target, mode)
	}

	def glGetTexParameterfv(target: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glGetTexParameterfv(target, pname, params)
	}

	def glGetTexParameteriv(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glGetTexParameteriv(target, pname, params)
	}

	def glGetTexParameterxv(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glGetTexParameterxv(target, pname, params)
	}

	def glGetTexEnvxv(env: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glGetTexEnvxv(env, pname, params)
	}

	def glGetString(name: Int): String = {
		instance.glGetString(name)
	}

	def glGetMaterialfv(face: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glGetMaterialfv(face, pname, params)
	}

	def glGetMaterialxv(face: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glGetMaterialxv(face, pname, params)
	}

	def glGetLightfv(light: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glGetLightfv(light, pname, params)
	}

	def glGetLightxv(light: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glGetLightxv(light, pname, params)
	}

	def glGetError(): Int = {
		instance.glGetError()
	}

	def glFrustumx(left: Int, right: Int, bottom: Int, top: Int, zNear: Int, zFar: Int): Unit = {
		instance.glFrustumx(left, right, bottom, top, zNear, zFar)
	}

	def glFrontFace(mode: Int): Unit = {
		instance.glFrontFace(mode)
	}

	def glFogfv(pname: Int, params: java.nio.FloatBuffer): Unit = {
		instance.glFogfv(pname, params)
	}

	def glFogx(pname: Int, param: Int): Unit = {
		instance.glFogx(pname, param)
	}

	def glFogxv(pname: Int, params: java.nio.IntBuffer): Unit = {
		instance.glFogxv(pname, params)
	}

	def glFogf(pname: Int, param: Float): Unit = {
		instance.glFogf(pname, param)
	}

	def glFlush(): Unit = {
		instance.glFlush()
	}

	def glFinish(): Unit = {
		instance.glFinish()
	}

	def glEnableClientState(array: Int): Unit = {
		instance.glEnableClientState(array)
	}

	def glEnable(cap: Int): Unit = {
		instance.glEnable(cap)
	}

	def glDrawElements(mode: Int, count: Int, `type`: Int, indices: java.nio.Buffer): Unit = {
		instance.glDrawElements(mode, count, `type`, indices)
	}

	def glDrawElements(mode: Int, count: Int, `type`: Int, offset: Int): Unit = {
		instance.glDrawElements(mode, count, `type`, offset)
	}

	def glDrawArrays(mode: Int, first: Int, count: Int): Unit = {
		instance.glDrawArrays(mode, first, count)
	}

	def glDisableClientState(array: Int): Unit = {
		instance.glDisableClientState(array)
	}

	def glDisable(cap: Int): Unit = {
		instance.glDisable(cap)
	}

	def glDepthRangex(zNear: Int, zFar: Int): Unit = {
		instance.glDepthRangex(zNear, zFar)
	}

	def glDepthRangef(zNear: Float, zFar: Float): Unit = {
		instance.glDepthRangef(zNear, zFar)
	}

	def glDepthMask(flag: Boolean): Unit = {
		instance.glDepthMask(flag)
	}

	def glDepthFunc(func: Int): Unit = {
		instance.glDepthFunc(func)
	}

	def glCullFace(mode: Int): Unit = {
		instance.glCullFace(mode)
	}

	def glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int): Unit = {
		instance.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
	}

	def glCopyTexImage2D(target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int): Unit = {
		instance.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
	}

	def glColorPointer(size: Int, `type`: Int, stride: Int, pointer: java.nio.Buffer): Unit = {
		instance.glColorPointer(size, `type`, stride, pointer)
	}

	def glColorPointer(size: Int, `type`: Int, stride: Int, offset: Int): Unit = {
		instance.glColorPointer(size, `type`, stride, offset)
	}

	def glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit = {
		instance.glColorMask(red, green, blue, alpha)
	}

	def glColor4x(red: Int, green: Int, blue: Int, alpha: Int): Unit = {
		instance.glColor4x(red, green, blue, alpha)
	}

	def glColor4f(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
		instance.glColor4f(red, green, blue, alpha)
	}

	def glClientActiveTexture(texture: Int): Unit = {
		instance.glClientActiveTexture(texture)
	}

	def glClearStencil(s: Int): Unit = {
		instance.glClearStencil(s)
	}

	def glClearDepthx(depth: Int): Unit = {
		instance.glClearDepthx(depth)
	}

	def glClearDepthf(depth: Float): Unit = {
		instance.glClearDepthf(depth)
	}

	def glClearColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
		instance.glClearColor(red, green, blue, alpha)
	}

	def glClear(mask: Int): Unit = {
		instance.glClear(mask)
	}

	def glBufferSubData(target: Int, offset: Int, size: Int, data: java.nio.Buffer): Unit = {
		instance.glBufferSubData(target, offset, size, data)
	}

	def glBufferData(target: Int, size: Int, data: java.nio.Buffer, usage: Int): Unit = {
		instance.glBufferData(target, size, data, usage)
	}

	def glBlendFunc(sfactor: Int, dfactor: Int): Unit = {
		instance.glBlendFunc(sfactor, dfactor)
	}

	def glBindTexture(target: Int, texture: Int): Unit = {
		instance.glBindTexture(target, texture)
	}

	def glBindBuffer(target: Int, buffer: Int): Unit = {
		instance.glBindBuffer(target, buffer)
	}

	def glAlphaFunc(func: Int, ref: Float): Unit = {
		instance.glAlphaFunc(func, ref)
	}

	def glActiveTexture(texture: Int): Unit = {
		instance.glActiveTexture(texture)
	}
}