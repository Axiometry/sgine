package org.sgine.ref

import ref.{ReferenceQueue, PhantomReference => JPR}


/**
 * PhantomReference wraps Scala's PhantomReference with additional features.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
class PhantomReference[T <: AnyRef] private(ref: JPR[T]) extends Reference[T] {
  def apply() = ref.apply()

  def clear() = ref.clear()

  def enqueue() = ref.enqueue()

  def get = ref.get

  def isEnqueued = ref.isEnqueued()
}

object PhantomReference {
  def apply[T <: AnyRef](value: T, queue: ReferenceQueue[T]) = new PhantomReference(new JPR(value, queue))
}