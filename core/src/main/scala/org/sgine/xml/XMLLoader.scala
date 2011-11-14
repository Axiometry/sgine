package org.sgine.xml

import xml.Elem

/**
 * XMLLoader converts an XML element to an object with the generic type defined by this instance.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
trait XMLLoader[T] {
  def apply(elem: Elem): T
}