package org.sgine.event

import scala.reflect.Manifest

class EventListener[E <: Event] private (val eventClass: Class[E], val f: Function1[E, Unit])(implicit manifest: Manifest[E]) extends Function1[Event, Unit] {
	def apply(evt: Event) = {
		if (isValidEvent(evt)) {
			f(evt.asInstanceOf[E])
		}
	}
	
//	def isValidEvent(evt: Event) = eventClass.isAssignableFrom(evt.getClass)
	def isValidEvent(evt: Event) = eventClass.isInstance(evt)
}

object EventListener {
	def apply[E <: Event](f: E => Unit)(implicit manifest: Manifest[E]): Event => Unit = {
//		val eventClass:Class[E] = EventListener.determineEventClass(f)
		val eventClass: Class[E] = manifest.erasure.asInstanceOf[Class[E]]
		if (eventClass == classOf[Event]) {
			// Don't wrap in EventListener if Event
			f.asInstanceOf[Function1[Event, Unit]]
		} else {
			// Wrap in EventListener for Event sub-classing
			new EventListener[E](eventClass, f)
		}
	}
	
//	private def determineEventClass[E <: Event](f: Function1[E, Unit]): Class[E] = {
//		for (m <- f.getClass.getMethods) {
//			if (m.getName == "apply") {
//				if (m.getParameterTypes.length == 1) {
//					if (classOf[Event].isAssignableFrom(m.getParameterTypes()(0))) {
//						return m.getParameterTypes()(0).asInstanceOf[Class[E]]
//					}
//				}
//			}
//		}
//		for (m <- f.getClass.getMethods) {
//			if (m.getName == "apply") {
//				if (m.getParameterTypes.length == 1) {
//					if (m.getParameterTypes()(0) == classOf[AnyRef]) {
//						return m.getParameterTypes()(0).asInstanceOf[Class[E]]
//					}
//				}
//			}
//		}
//		throw new NullPointerException("Unable to find event class for " + f.getClass)
//	}
}