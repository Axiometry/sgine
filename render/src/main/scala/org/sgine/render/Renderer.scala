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

package org.sgine.render

import implementation.opengl.OpenGLRenderer
import org.sgine.math.Matrix4
import org.sgine.Disposable
import org.sgine.opengl.lwjgl.LWJGLController
import java.lang.ThreadLocal
import java.nio.ByteBuffer

/**
 * Renderer implementation is defined by the current rendering platform available.
 * This is <b>NOT</b> thread-safe, all operations should occur in the same thread.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
trait Renderer extends Disposable {
  def application: RenderApplication

  def create() = {
    Renderer.renderer.set(this)
    application.bodyFunction()
  }

  protected[render] def createShape(vertices: Seq[Float]): Shape

  protected[render] def createMutableShape(vertices: Seq[Float]): MutableShape

  protected[render] def createTexture(width: Int, height: Int, buffer: ByteBuffer, mipmap: Boolean): Texture

  protected[render] def createTextureCoords(coords: Seq[Float]): TextureCoords

  def loadMatrix(matrix: Matrix4): Unit
}

object Renderer {
  private val renderer = new ThreadLocal[Renderer]

  def apply(application: RenderApplication) = {
    val renderer = new OpenGLRenderer(application)
    val controller = LWJGLController(renderer, 1024, 768, application.title)
    renderer
  }

  def apply() = renderer.get()
}