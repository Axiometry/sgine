package org.sgine

import naming.{NamingFilter, NamingParent}
import util.Random

/**
 * Enumerated represents the companion object for EnumEntry instances.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
trait Enumerated[E <: EnumEntry[E]] extends NamingParent {
  implicit val enumerated = this

  private lazy val r = new Random()

  /**
   * The name of this Enumerated.
   */
  lazy val name = getClass.getSimpleName.replaceAll("\\$", "")

  /**
   * Retrieve the EnumEntry by name.
   *
   * @param name the name of the EnumEntry as defined by the field.
   * @return EnumEntry or null if not found
   */
  def apply(name: String) = values.find(e => e.name == name).getOrElse(null.asInstanceOf[E])

  /**
   * Retrieve the EnumEntry by index.
   *
   * @param index of the EnumEntry.
   * @return EnumEntry or IndexOutOfBoundsException
   */
  def apply(index: Int) = values(index)

  /**
   * All EnumEntries for this Enumerated instance.
   */
  lazy val values = new NamingFilter[E](this)

  /**
   * Retrieves a random enum.
   */
  def random = values(r.nextInt(values.length))
}