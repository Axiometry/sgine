package org.sgine.scene.ext

import org.sgine.event.EventHandler
import org.sgine.event.ProcessingMode

import org.sgine.input.Key
import org.sgine.input.Keyboard
import org.sgine.input.event.KeyReleaseEvent

import org.sgine.property.AdvancedProperty
import org.sgine.property.event.PropertyChangeEvent

import org.sgine.scene.Node

trait FocusableNode extends Node {
	val focused = new AdvancedProperty[Boolean](false, this)
	
	focused.listeners += EventHandler(focusChanged, ProcessingMode.Blocking)
	
	private def focusChanged(evt: PropertyChangeEvent[Boolean]) = {
		if (evt.newValue) {
			FocusableNode.focus(this)
		} else {
			FocusableNode.blur(this)
		}
	}
}

object FocusableNode {
	val focused = new AdvancedProperty[FocusableNode](null)
	val enabled = new AdvancedProperty[Boolean](true)
	
	Keyboard.listeners += EventHandler(keyReleased, ProcessingMode.Blocking)
	
	def focus(n: FocusableNode) = {
		val current = focused()
		if (current != null) {
			blur(current)
		}
		if (focused() != n) focused := n
		if (!n.focused()) n.focused := true
	}
	
	def blur(n: FocusableNode) = {
		val current = focused()
		if (current == n) {
			if (n.focused()) n.focused := false
			
			focused := null
		}
	}
	
	private def keyReleased(evt: KeyReleaseEvent) = {
		if (evt.key == Key.Tab) {
			if (evt.shiftDown) {
				println("Reverse TAB!")
			} else {
				println("TAB!")
			}
		}
	}
}