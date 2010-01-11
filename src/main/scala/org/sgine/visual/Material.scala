package org.sgine.visual

import org.sgine.property._
import org.sgine.property.container._

import org.sgine.visual.material._

trait Material extends PropertyContainer {
	val pigment = new AdvancedProperty[Pigment](null, this)
	val normal = new AdvancedProperty[Normal](null, this)
	val finish = new AdvancedProperty[Finish](null, this)
}

object Material {
	def apply(pigment: Pigment) = {
		val m = new MaterialImpl
		m.pigment := pigment
		
		m
	}
}

class MaterialImpl extends Material