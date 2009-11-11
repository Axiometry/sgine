package com.sgine.property

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ProptertyTests extends FlatSpec with ShouldMatchers {
	"Property" should "assign values properly" in {
		val p = new ImmutableProperty(5)
		p() should equal (5)
	}
}