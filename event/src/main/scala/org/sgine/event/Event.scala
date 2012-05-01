package org.sgine.event

import org.sgine.bus.Bus

/**
 * Event is the core object sent to listeners.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 * Date: 12/3/11
 */
trait Event {
  private var _target: Listenable = _
  private var _cause: Event = _

  final def target = _target
  final def cause = _cause

  /**
   * If this returns true then this event will only fire on synchronous listeners and all other processing modes will
   * ignore this event.
   *
   * Defaults to false.
   */
  def singleThreaded = false

  val thread = Thread.currentThread()
}

object Event {
  private val _current = new ThreadLocal[Event]()
  def current = _current.get()

  def apply() = new BasicEvent

  def fire(event: Event, target: Listenable) = {
    if (event._target != null && !event.singleThreaded) throw new RuntimeException("Events can only be fired once!")
    event._cause = current
    event._target = target
    _current.set(event)
    val routing = Bus(event)
    _current.set(event.cause)
    routing
  }
}

class BasicEvent extends Event