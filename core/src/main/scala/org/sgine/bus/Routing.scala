package org.sgine.bus

import org.sgine.{Enumerated, EnumEntry}

/**
 * Routing is used as a response from Node to determine how the Bus should proceed with processing of the message.
 *
 * @author Matt Hicks <mhicks@sgine.org>
 */
class Routing extends EnumEntry[Routing]

object Routing extends Enumerated[Routing] {
  /**
   * Returned by a Node to allow the message to continue processing along to Bus.
   */
  val Continue = new Routing()

  /**
   * Returned by a Node to stop processing by additional Nodes.
   */
  val Stop = new Routing()

  /**
   * Returned by a Node to stop processing and return the supplied response value.
   */
  def Response(response: Any) = new RoutingResponse(response)

  /**
   * Returned by a Node to represent results. Results works like a Response except continues processing and allows the
   * adding up of additional results from more Nodes while continuing to process the message.
   */
  def Results(results: List[Any]) = new RoutingResults(results)
}

class RoutingResponse private[bus](val response: Any) extends Routing {
  override lazy val name = "Response"
}

class RoutingResults private[bus](val results: List[Any]) extends Routing {
  override lazy val name = "Results"
}