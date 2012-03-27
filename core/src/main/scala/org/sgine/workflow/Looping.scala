package org.sgine.workflow

/**
 * Adds looping support to a Workflow
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
trait Looping extends Workflow {
  private var iteration = 0

  def loops: Int

  override def act(delta: Float) = {
    if (super.act(delta)) {
      iteration += 1

      currentItems = items
      current = null

      iteration >= loops
    } else {
      false
    }
  }

  override def end() = {
    super.end()
    iteration = 0
  }
}