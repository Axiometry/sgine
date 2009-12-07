package org.sgine.space.bounds

import org.sgine.math.Vector3

/**
 * Represents a spherical bounding volume.
 */
final case class SphericalBounds( radius : Double)  extends Bounds {

  def intersects(location: Vector3, otherLocation: Vector3, otherBounds: Bounds) = {
    otherBounds match {
      case other : SphericalBounds =>
        location.distanceSquared( otherLocation ) <= radius*radius + other.radius*other.radius
    }

  }
}