package com.sgine.property

import com.sgine._;
import com.sgine.property.adjust._;

/**
 * AdjustableProperty trait provides time-based changes to occur over
 * time rather than immediate change when <code>apply(t:T)</code> is
 * called. This trait requires the <code>update</code> method be invoked
 * in order to asynchronously adjust the value to its target value.
 * 
 * @author Matt Hicks
 */
trait AdjustableProperty[T] extends Property[T] with Updatable {
	var adjuster:Function3[T, T, Double, T] = defaultAdjuster
	
	private var target:T = apply();
	
	abstract override def apply(value:T):Property[T] = {
		target = value
		
		this
	}
	
	def update(time:Double) = {
		if (adjuster != null) {
			val current:T = apply()
			
			if (current != target) {
				val result:T = adjuster(current, target, time)
				
				super.apply(result)
			}
		}
	}
	
	def isAdjusting() = apply() == target
	
	def defaultAdjuster(current:T, target:T, elapsed:Double):T = target;
}