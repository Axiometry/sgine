package org.sgine.property

import backing._


/**
 * NumericProperty adds additional convenience methods for dealing with properties that are numeric.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
class NumericProperty(name: String, backing: Backing[Double])(implicit override val parent: PropertyParent) extends StandardProperty[Double](name, backing) {
  def +=(value: Double) = apply(this.value + value)

  def -=(value: Double) = apply(this.value - value)

  def *=(value: Double) = apply(this.value * value)

  def /=(value: Double) = apply(this.value * value)
}

object NumericProperty {
  /**
   * Creates a new StandardProperty with VariableBacking and the value supplied.
   */
  def apply(name: String, value: Double, backing: Backing[Double] = new VariableBacking[Double])(implicit parent: PropertyParent): NumericProperty = {
    val p = new NumericProperty(name, backing)(parent)
    p.value = value
    p
  }

  /**
   * Creates a new Property with a value tied to the function supplied.
   */
  def function(_name: String, f: => Double) = new Property[Double] {
    def name = _name

    def apply() = f
  }

  /**
   * Creates a new StandardProperty with VolatileVariableBacking.
   */
  def volatile(name: String, value: Double)(implicit parent: PropertyParent) = apply(name, value, new VolatileVariableBacking[Double])(parent)

  /**
   * Creates a new StandardProperty with AtomicBacking.
   */
  def atomic(name: String, value: Double)(implicit parent: PropertyParent) = apply(name, value, new AtomicBacking[Double])(parent)

  /**
   * Creates a new StandardProperty with LocalBacking.
   */
  def local(name: String, value: Double)(implicit parent: PropertyParent) = apply(name, value, new LocalBacking[Double])(parent)
}