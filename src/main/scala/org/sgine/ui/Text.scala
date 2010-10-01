package org.sgine.ui

import org.sgine.core.HorizontalAlignment
import org.sgine.core.ProcessingMode
import org.sgine.core.VerticalAlignment

import org.sgine.event.Event
import org.sgine.event.EventHandler
import org.sgine.event.Listenable

import org.sgine.input.Key
import org.sgine.input.event._

import org.sgine.property.AdvancedProperty
import org.sgine.property.event.PropertyChangeEvent

import org.sgine.render.font.BitmapFont
import org.sgine.render.font.Font
import org.sgine.render.font.FontManager
import org.sgine.render.font.RenderedCharacter
import org.sgine.render.font.RenderedLine
import org.sgine.render.font.WordWrap

import org.sgine.scene.ext.FocusableNode

import org.sgine.ui.ext.Caret
import org.sgine.ui.ext.Selection

import org.lwjgl.opengl.GL11._

class Text extends ShapeComponent with FocusableNode {
	val cull = _cull
	val font = new AdvancedProperty[Font](FontManager("Arial32"), this)
	val text = new AdvancedProperty[String]("", this)
	val kern = new AdvancedProperty[Boolean](true, this)
	val horizontalAlignment = new AdvancedProperty[HorizontalAlignment](HorizontalAlignment.Center, this)
	val verticalAlignment = new AdvancedProperty[VerticalAlignment](VerticalAlignment.Middle, this)
	val editable = new AdvancedProperty[Boolean](false, this)
	
	protected[ui] val lines = new AdvancedProperty[Seq[RenderedLine]](Nil, this)
	@scala.annotation.tailrec
	protected[ui] final def char(index: Int, lines: Seq[RenderedLine] = this.lines()): Option[RenderedCharacter] = {
		if (lines == Nil) {
			None
		} else {
			val l = lines.head
			if (l.characters.length > index) {
				Some(l.characters(index))
			} else {
				char(index - l.characters.length, lines.tail)
			}
		}
	}
	
	val selection = new Selection(this)
	val caret = new Caret(this)
	
	Listenable.listenTo(EventHandler(invalidateText, ProcessingMode.Blocking),
						font,
						text,
						size.width,
						size.height,
						kern,
						horizontalAlignment,
						verticalAlignment)
	
	listeners += EventHandler(keyPress, ProcessingMode.Blocking)
						
	private val revalidateText = new java.util.concurrent.atomic.AtomicBoolean(false)
	
	override def drawComponent() = {
		if (revalidateText.get) {
			revalidateText.set(false)
			validateText()
		}
		
		super.drawComponent()
		caret.draw()
	}
	
	private def invalidateText(evt: PropertyChangeEvent[_]) = {
		if (evt.property == text) {
			caret.position := 0
		}
		revalidateText.set(true)
	}
	
	private def validateText() = {
		lines := font()(shape, text(), kern(), size.width(), WordWrap, verticalAlignment(), horizontalAlignment())
		font() match {
			case bf: BitmapFont => texture = bf.texture
			case _ =>
		}
	}
	
	private def keyPress(evt: KeyPressEvent) = {
		evt.key match {
			case Key.Left => caret.position := caret.position() - 1
			case Key.Right => caret.position := caret.position() + 1
			case _ =>
		}
	}
}