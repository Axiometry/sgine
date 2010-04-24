package org.sgine.ui

import org.lwjgl.opengl.GL11._

import org.sgine.event.Listenable

import org.sgine.math.mutable.MatrixPropertyContainer

import org.sgine.property.AdvancedProperty
import org.sgine.property.DelegateProperty
import org.sgine.property.ImmutableProperty
import org.sgine.property.container.PropertyContainer

import org.sgine.render.Renderable
import org.sgine.render.Renderer

import org.sgine.scene.NodeContainer

import org.sgine.ui.ext._

trait Component extends PropertyContainer with Renderable with MatrixPropertyContainer {
	val id = new AdvancedProperty[String](null, this)
	val visible = new AdvancedProperty[Boolean](true, this)
	val renderer = new DelegateProperty(() => _renderer)
	
	private var firstRender = true
	
	private var _renderer: Renderer = _
	
	def render(renderer: Renderer) = {
		_renderer = renderer
		if (visible()) {				// Only render if the component is visible
			if (firstRender) {
				firstRender = false
				initComponent()
			}
			
			preRender()
			glLoadMatrix(matrix().buffer)
			
			drawComponent()
		}
	}
	
	protected def initComponent() = {
	}
	
	protected def preRender() = {
	}
	
	def drawComponent()
}