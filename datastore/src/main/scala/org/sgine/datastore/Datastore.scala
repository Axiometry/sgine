package org.sgine.datastore

/**
 * @author Matt Hicks <mhicks@sgine.org>
 */
trait Datastore {
  private val sessions = new ThreadLocal[DatastoreSession]

  /**
   * @return the existing session for this thread or null if one does not exist.
   */
  def session = sessions.get()

  /**
   * Executes the supplied function within a local session. If a session already exists it will be utilized or a new one
   * will be created and terminated upon completion of the session block.
   *
   * @param f the function to execute within the session
   * @return the result from the function
   */
  def apply[T](f: DatastoreSession => T): T = {
    val (currentSession, created) = createOrGet()
    try {
      f(currentSession)
    } finally {
      if (created) {
        disconnect()
      }
    }
  }

  def createOrGet() = {
    session match {
      case null => {
        val s = createSession()
        sessions.set(s)
        s -> true
      }
      case s => s -> false
    }
  }

  def disconnect() = {
    session.disconnect()
    sessions.set(null)
  }

  /**
   * @return a new session for use with this datastore
   */
  protected def createSession(): DatastoreSession
}
