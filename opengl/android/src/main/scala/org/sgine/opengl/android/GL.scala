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
object GL extends org.sgine.opengl.GL {
	def glDeleteBuffer(id: Int): Unit = {
		android.opengl.GLES11.glDeleteBuffers(1, Array(id), 0)
	}

	def glGenBuffers(n: Int, buffers: Array[Int], offset: Int): Unit = {
		android.opengl.GLES11.glGenBuffers(n, buffers, offset)
	}

	def glGenBuffer(): Int = {
		val buffers = new Array[Int](1)
		android.opengl.GLES11.glGenBuffers(1, buffers, 0)
		buffers(0)
	}

	def glGenBuffers(buffers: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glGenBuffers(0, buffers)
	}

	def glDeleteBuffers(n: Int, buffers: Array[Int], offset: Int): Unit = {
		android.opengl.GLES11.glDeleteBuffers(n, buffers, offset)
	}

	def glBufferData(target: Int, size: Int, data: java.nio.Buffer, usage: Int): Unit = {
		android.opengl.GLES11.glBufferData(target, size, data, usage)
	}

	def glVertexPointer(size: Int, `type`: Int, stride: Int, pointer: java.nio.Buffer): Unit = {
		android.opengl.GLES10.glVertexPointer(size, `type`, stride, pointer)
	}

	def glViewport(x: Int, y: Int, width: Int, height: Int): Unit = {
		android.opengl.GLES20.glViewport(x, y, width, height)
	}

	def glVertexPointer(size: Int, `type`: Int, stride: Int, offset: Int): Unit = {
		android.opengl.GLES11.glVertexPointer(size, `type`, stride, offset)
	}

	def glVertexAttrib1f(indx: Int, x: Float): Unit = {
		android.opengl.GLES20.glVertexAttrib1f(indx, x)
	}

	def glVertexAttrib2f(indx: Int, x: Float, y: Float): Unit = {
		android.opengl.GLES20.glVertexAttrib2f(indx, x, y)
	}

	def glVertexAttrib3f(indx: Int, x: Float, y: Float, z: Float): Unit = {
		android.opengl.GLES20.glVertexAttrib3f(indx, x, y, z)
	}

	def glVertexAttrib4f(indx: Int, x: Float, y: Float, z: Float, w: Float): Unit = {
		android.opengl.GLES20.glVertexAttrib4f(indx, x, y, z, w)
	}

	def glValidateProgram(program: Int): Unit = {
		android.opengl.GLES20.glValidateProgram(program)
	}

	def glUseProgram(program: Int): Unit = {
		android.opengl.GLES20.glUseProgram(program)
	}

	def glUniform1f(location: Int, x: Float): Unit = {
		android.opengl.GLES20.glUniform1f(location, x)
	}

	def glUniform1i(location: Int, x: Int): Unit = {
		android.opengl.GLES20.glUniform1i(location, x)
	}

	def glUniform2f(location: Int, x: Float, y: Float): Unit = {
		android.opengl.GLES20.glUniform2f(location, x, y)
	}

	def glUniform2i(location: Int, x: Int, y: Int): Unit = {
		android.opengl.GLES20.glUniform2i(location, x, y)
	}

	def glUniform3f(location: Int, x: Float, y: Float, z: Float): Unit = {
		android.opengl.GLES20.glUniform3f(location, x, y, z)
	}

	def glUniform3i(location: Int, x: Int, y: Int, z: Int): Unit = {
		android.opengl.GLES20.glUniform3i(location, x, y, z)
	}

	def glUniform4f(location: Int, x: Float, y: Float, z: Float, w: Float): Unit = {
		android.opengl.GLES20.glUniform4f(location, x, y, z, w)
	}

	def glUniform4i(location: Int, x: Int, y: Int, z: Int, w: Int): Unit = {
		android.opengl.GLES20.glUniform4i(location, x, y, z, w)
	}

	def glTranslatef(x: Float, y: Float, z: Float): Unit = {
		android.opengl.GLES10.glTranslatef(x, y, z)
	}

	def glTexParameter(target: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES20.glTexParameterfv(target, pname, params)
	}

	def glTexParameterI(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glTexParameteriv(target, pname, params)
	}

	def glTexParameterIu(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES20.glTexParameteriv(target, pname, params)
	}

	def glTexParameterIi(target: Int, pname: Int, param: Int): Unit = {
		android.opengl.GLES10.glTexParameterx(target, pname, param)
	}

	def glTexParameterf(target: Int, pname: Int, param: Float): Unit = {
		android.opengl.GLES20.glTexParameterf(target, pname, param)
	}

	def glTexParameteri(target: Int, pname: Int, param: Int): Unit = {
		android.opengl.GLES20.glTexParameteri(target, pname, param)
	}

	def glTexEnv(target: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glTexEnvfv(target, pname, params)
	}

	def glTexEnv(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES10.glTexEnvxv(target, pname, params)
	}

	def glTexEnvf(target: Int, pname: Int, param: Float): Unit = {
		android.opengl.GLES10.glTexEnvf(target, pname, param)
	}

	def glTexEnvi(target: Int, pname: Int, param: Int): Unit = {
		android.opengl.GLES11.glTexEnvi(target, pname, param)
	}

	def glTexCoordPointer(size: Int, `type`: Int, stride: Int, offset: Int): Unit = {
		android.opengl.GLES11.glTexCoordPointer(size, `type`, stride, offset)
	}

	def glStencilOpSeparate(face: Int, fail: Int, zfail: Int, zpass: Int): Unit = {
		android.opengl.GLES20.glStencilOpSeparate(face, fail, zfail, zpass)
	}

	def glStencilOp(fail: Int, zfail: Int, zpass: Int): Unit = {
		android.opengl.GLES20.glStencilOp(fail, zfail, zpass)
	}

	def glStencilMaskSeparate(face: Int, mask: Int): Unit = {
		android.opengl.GLES20.glStencilMaskSeparate(face, mask)
	}

	def glStencilMask(mask: Int): Unit = {
		android.opengl.GLES20.glStencilMask(mask)
	}

	def glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): Unit = {
		android.opengl.GLES20.glStencilFuncSeparate(face, func, ref, mask)
	}

	def glStencilFunc(func: Int, ref: Int, mask: Int): Unit = {
		android.opengl.GLES20.glStencilFunc(func, ref, mask)
	}

	def glShaderSource(shader: Int, string: String): Unit = {
		android.opengl.GLES20.glShaderSource(shader, string)
	}

	def glShadeModel(mode: Int): Unit = {
		android.opengl.GLES10.glShadeModel(mode)
	}

	def glScissor(x: Int, y: Int, width: Int, height: Int): Unit = {
		android.opengl.GLES20.glScissor(x, y, width, height)
	}

	def glScalef(x: Float, y: Float, z: Float): Unit = {
		android.opengl.GLES10.glScalef(x, y, z)
	}

	def glSampleCoverage(value: Float, invert: Boolean): Unit = {
		android.opengl.GLES20.glSampleCoverage(value, invert)
	}

	def glRotatef(angle: Float, x: Float, y: Float, z: Float): Unit = {
		android.opengl.GLES10.glRotatef(angle, x, y, z)
	}

	def glPushMatrix(): Unit = {
		android.opengl.GLES10.glPushMatrix()
	}

	def glPopMatrix(): Unit = {
		android.opengl.GLES10.glPopMatrix()
	}

	def glPolygonOffset(factor: Float, units: Float): Unit = {
		android.opengl.GLES20.glPolygonOffset(factor, units)
	}

	def glPointSize(size: Float): Unit = {
		android.opengl.GLES10.glPointSize(size)
	}

	def glPointParameter(pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES11.glPointParameterfv(pname, params)
	}

	def glPointParameteri(pname: Int, param: Int): Unit = {
		android.opengl.GLES11.glPointParameterx(pname, param)
	}

	def glPointParameter(pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glPointParameterxv(pname, params)
	}

	def glPointParameterf(pname: Int, param: Float): Unit = {
		android.opengl.GLES11.glPointParameterf(pname, param)
	}

	def glPixelStorei(pname: Int, param: Int): Unit = {
		android.opengl.GLES20.glPixelStorei(pname, param)
	}

	def glOrtho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Unit = {
		android.opengl.GLES10.glOrthof(left, right, bottom, top, zNear, zFar)
	}

	def glNormalPointer(`type`: Int, stride: Int, offset: Int): Unit = {
		android.opengl.GLES11.glNormalPointer(`type`, stride, offset)
	}

	def glNormal3i(nx: Int, ny: Int, nz: Int): Unit = {
		android.opengl.GLES10.glNormal3x(nx, ny, nz)
	}

	def glNormal3f(nx: Float, ny: Float, nz: Float): Unit = {
		android.opengl.GLES10.glNormal3f(nx, ny, nz)
	}

	def glMultiTexCoord4f(target: Int, s: Float, t: Float, r: Float, q: Float): Unit = {
		android.opengl.GLES10.glMultiTexCoord4f(target, s, t, r, q)
	}

	def glMultMatrix(m: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glMultMatrixf(m)
	}

	def glMatrixMode(mode: Int): Unit = {
		android.opengl.GLES10.glMatrixMode(mode)
	}

	def glMaterial(face: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glMaterialfv(face, pname, params)
	}

	def glMateriali(face: Int, pname: Int, param: Int): Unit = {
		android.opengl.GLES10.glMaterialx(face, pname, param)
	}

	def glMaterial(face: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES10.glMaterialxv(face, pname, params)
	}

	def glMaterialf(face: Int, pname: Int, param: Float): Unit = {
		android.opengl.GLES10.glMaterialf(face, pname, param)
	}

	def glLogicOp(opcode: Int): Unit = {
		android.opengl.GLES10.glLogicOp(opcode)
	}

	def glLoadMatrix(m: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glLoadMatrixf(m)
	}

	def glLoadIdentity(): Unit = {
		android.opengl.GLES10.glLoadIdentity()
	}

	def glLinkProgram(program: Int): Unit = {
		android.opengl.GLES20.glLinkProgram(program)
	}

	def glLineWidth(width: Float): Unit = {
		android.opengl.GLES20.glLineWidth(width)
	}

	def glLightModel(pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glLightModelfv(pname, params)
	}

	def glLightModeli(pname: Int, param: Int): Unit = {
		android.opengl.GLES10.glLightModelx(pname, param)
	}

	def glLightModel(pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES10.glLightModelxv(pname, params)
	}

	def glLightModelf(pname: Int, param: Float): Unit = {
		android.opengl.GLES10.glLightModelf(pname, param)
	}

	def glLight(light: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glLightfv(light, pname, params)
	}

	def glLighti(light: Int, pname: Int, param: Int): Unit = {
		android.opengl.GLES10.glLightx(light, pname, param)
	}

	def glLight(light: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES10.glLightxv(light, pname, params)
	}

	def glLightf(light: Int, pname: Int, param: Float): Unit = {
		android.opengl.GLES10.glLightf(light, pname, param)
	}

	def glIsTexture(texture: Int): Boolean = {
		android.opengl.GLES20.glIsTexture(texture)
	}

	def glIsShader(shader: Int): Boolean = {
		android.opengl.GLES20.glIsShader(shader)
	}

	def glIsProgram(program: Int): Boolean = {
		android.opengl.GLES20.glIsProgram(program)
	}

	def glIsEnabled(cap: Int): Boolean = {
		android.opengl.GLES20.glIsEnabled(cap)
	}

	def glIsBuffer(buffer: Int): Boolean = {
		android.opengl.GLES20.glIsBuffer(buffer)
	}

	def glHint(target: Int, mode: Int): Unit = {
		android.opengl.GLES20.glHint(target, mode)
	}

	def glGetVertexAttrib(index: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES20.glGetVertexAttribfv(index, pname, params)
	}

	def glGetVertexAttribIu(index: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES20.glGetVertexAttribiv(index, pname, params)
	}

	def glGetUniformLocation(program: Int, name: String): Int = {
		android.opengl.GLES20.glGetUniformLocation(program, name)
	}

	def glGetUniform(program: Int, location: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES20.glGetUniformfv(program, location, params)
	}

	def glGetUniformu(program: Int, location: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES20.glGetUniformiv(program, location, params)
	}

	def glGetTexParameter(target: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES20.glGetTexParameterfv(target, pname, params)
	}

	def glGetTexParameterI(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glGetTexParameteriv(target, pname, params)
	}

	def glGetTexParameterIu(target: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES20.glGetTexParameteriv(target, pname, params)
	}

	def glGetTexEnv(env: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES11.glGetTexEnvfv(env, pname, params)
	}

	def glGetTexEnv(env: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glGetTexEnvxv(env, pname, params)
	}

	def glGetString(name: Int): String = {
		android.opengl.GLES20.glGetString(name)
	}

	def glGetShader(shader: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES20.glGetShaderiv(shader, pname, params)
	}

	def glGetProgram(program: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES20.glGetProgramiv(program, pname, params)
	}

	def glGetMaterial(face: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES11.glGetMaterialfv(face, pname, params)
	}

	def glGetMaterial(face: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glGetMaterialxv(face, pname, params)
	}

	def glGetLight(light: Int, pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES11.glGetLightfv(light, pname, params)
	}

	def glGetLight(light: Int, pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES11.glGetLightxv(light, pname, params)
	}

	def glGetError(): Int = {
		android.opengl.GLES20.glGetError()
	}

	def glGetAttribLocation(program: Int, name: String): Int = {
		android.opengl.GLES20.glGetAttribLocation(program, name)
	}

	def glFrustum(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Unit = {
		android.opengl.GLES10.glFrustumf(left, right, bottom, top, zNear, zFar)
	}

	def glFrontFace(mode: Int): Unit = {
		android.opengl.GLES20.glFrontFace(mode)
	}

	def glFog(pname: Int, params: java.nio.FloatBuffer): Unit = {
		android.opengl.GLES10.glFogfv(pname, params)
	}

	def glFogi(pname: Int, param: Int): Unit = {
		android.opengl.GLES10.glFogx(pname, param)
	}

	def glFog(pname: Int, params: java.nio.IntBuffer): Unit = {
		android.opengl.GLES10.glFogxv(pname, params)
	}

	def glFogf(pname: Int, param: Float): Unit = {
		android.opengl.GLES10.glFogf(pname, param)
	}

	def glFlush(): Unit = {
		android.opengl.GLES20.glFlush()
	}

	def glFinish(): Unit = {
		android.opengl.GLES20.glFinish()
	}

	def glEnableVertexAttribArray(index: Int): Unit = {
		android.opengl.GLES20.glEnableVertexAttribArray(index)
	}

	def glEnableClientState(array: Int): Unit = {
		android.opengl.GLES10.glEnableClientState(array)
	}

	def glEnable(cap: Int): Unit = {
		android.opengl.GLES20.glEnable(cap)
	}

	def glDrawElements(mode: Int, count: Int, `type`: Int, offset: Int): Unit = {
		android.opengl.GLES11.glDrawElements(mode, count, `type`, offset)
	}

	def glDrawArrays(mode: Int, first: Int, count: Int): Unit = {
		android.opengl.GLES20.glDrawArrays(mode, first, count)
	}

	def glDisableVertexAttribArray(index: Int): Unit = {
		android.opengl.GLES20.glDisableVertexAttribArray(index)
	}

	def glDisableClientState(array: Int): Unit = {
		android.opengl.GLES10.glDisableClientState(array)
	}

	def glDisable(cap: Int): Unit = {
		android.opengl.GLES20.glDisable(cap)
	}

	def glDetachShader(program: Int, shader: Int): Unit = {
		android.opengl.GLES20.glDetachShader(program, shader)
	}

	def glDepthRange(zNear: Float, zFar: Float): Unit = {
		android.opengl.GLES10.glDepthRangef(zNear, zFar)
	}

	def glDepthRangef(zNear: Float, zFar: Float): Unit = {
		android.opengl.GLES20.glDepthRangef(zNear, zFar)
	}

	def glDepthMask(flag: Boolean): Unit = {
		android.opengl.GLES20.glDepthMask(flag)
	}

	def glDepthFunc(func: Int): Unit = {
		android.opengl.GLES20.glDepthFunc(func)
	}

	def glDeleteShader(shader: Int): Unit = {
		android.opengl.GLES20.glDeleteShader(shader)
	}

	def glDeleteProgram(program: Int): Unit = {
		android.opengl.GLES20.glDeleteProgram(program)
	}

	def glCullFace(mode: Int): Unit = {
		android.opengl.GLES20.glCullFace(mode)
	}

	def glCreateShader(`type`: Int): Int = {
		android.opengl.GLES20.glCreateShader(`type`)
	}

	def glCreateProgram(): Int = {
		android.opengl.GLES20.glCreateProgram()
	}

	def glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int, width: Int, height: Int): Unit = {
		android.opengl.GLES20.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
	}

	def glCopyTexImage2D(target: Int, level: Int, internalformat: Int, x: Int, y: Int, width: Int, height: Int, border: Int): Unit = {
		android.opengl.GLES20.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
	}

	def glCompileShader(shader: Int): Unit = {
		android.opengl.GLES20.glCompileShader(shader)
	}

	def glColorPointer(size: Int, `type`: Int, stride: Int, offset: Int): Unit = {
		android.opengl.GLES11.glColorPointer(size, `type`, stride, offset)
	}

	def glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit = {
		android.opengl.GLES20.glColorMask(red, green, blue, alpha)
	}

	def glColor4f(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
		android.opengl.GLES10.glColor4f(red, green, blue, alpha)
	}

	def glClientActiveTexture(texture: Int): Unit = {
		android.opengl.GLES10.glClientActiveTexture(texture)
	}

	def glClearStencil(s: Int): Unit = {
		android.opengl.GLES20.glClearStencil(s)
	}

	def glClearDepth(depth: Float): Unit = {
		android.opengl.GLES20.glClearDepthf(depth)
	}

	def glClearColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
		android.opengl.GLES20.glClearColor(red, green, blue, alpha)
	}

	def glClear(mask: Int): Unit = {
		android.opengl.GLES20.glClear(mask)
	}

	def glBlendFuncSeparate(srcRGB: Int, dstRGB: Int, srcAlpha: Int, dstAlpha: Int): Unit = {
		android.opengl.GLES20.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha)
	}

	def glBlendFunc(sfactor: Int, dfactor: Int): Unit = {
		android.opengl.GLES20.glBlendFunc(sfactor, dfactor)
	}

	def glBlendEquationSeparate(modeRGB: Int, modeAlpha: Int): Unit = {
		android.opengl.GLES20.glBlendEquationSeparate(modeRGB, modeAlpha)
	}

	def glBlendEquation(mode: Int): Unit = {
		android.opengl.GLES20.glBlendEquation(mode)
	}

	def glBlendColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
		android.opengl.GLES20.glBlendColor(red, green, blue, alpha)
	}

	def glBindTexture(target: Int, texture: Int): Unit = {
		android.opengl.GLES20.glBindTexture(target, texture)
	}

	def glBindBuffer(target: Int, buffer: Int): Unit = {
		android.opengl.GLES20.glBindBuffer(target, buffer)
	}

	def glBindAttribLocation(program: Int, index: Int, name: String): Unit = {
		android.opengl.GLES20.glBindAttribLocation(program, index, name)
	}

	def glAttachShader(program: Int, shader: Int): Unit = {
		android.opengl.GLES20.glAttachShader(program, shader)
	}

	def glAlphaFunc(func: Int, ref: Float): Unit = {
		android.opengl.GLES10.glAlphaFunc(func, ref)
	}

	def glActiveTexture(texture: Int): Unit = {
		android.opengl.GLES20.glActiveTexture(texture)
	}
}