package com.sgine.work

import com.sgine.util._;
import com.sgine.work.unit._;

import java.util.concurrent._;
import java.util.concurrent.locks._;

class WorkManager {
	/**
	 * @see WorkManager#DEFAULT_THREAD_SETTLING
	 */
	var threadSettling = WorkManager.DEFAULT_THREAD_SETTLING;
	var workLoadThreshold = WorkManager.DEFAULT_WORK_LOAD_THRESHOLD;
	var workDelayThreshold = WorkManager.DEFAULT_WORK_DELAY_THRESHOLD;
	var threadWait = WorkManager.DEFAULT_THREAD_WAIT;
	var maxThreads = WorkManager.DEFAULT_MAX_THREADS;
	var monitoringDelay = WorkManager.DEFAULT_MONITORING_DELAY;
	var allowOverloading = WorkManager.DEFAULT_ALLOW_OVERLOADING;
	var threadYielding = WorkManager.DEFAULT_THREAD_YIELDING;
	var uncaughtExceptionHandler = (exc:Throwable) => {
		exc.printStackTrace();
	}
	
	private val queue = new ConcurrentLinkedQueue[() => Unit]();
	private val workers = new ConcurrentLinkedQueue[WorkThread]();
	
	private[work] val monitor = new Thread(FunctionRunnable(run));
	
	private var started = false;
	private var keepAlive = true;
	
	implicit def clq2iterable[T](clq:ConcurrentLinkedQueue[T]) =
		new Iterable[T]() {
			override def iterator:Iterator[T] = {
				val i = clq.iterator();
				new Iterator[T]() {
					def hasNext() = {
						i.hasNext();
					}
					
					def next() = {
						i.next();
					}
				}
			}
		}
	
	private def init() = {
		if (!started) {
			synchronized {
				if (!started) {
					started = true;
					monitor.setDaemon(true);
					monitor.start();
					
					addWorker();
				}
			}
		}
	}
	
	private def run():Unit = {
		while (keepAlive) {
			val lastTime = WorkManager.time;
			WorkManager._time = System.currentTimeMillis;
			
			val time = (WorkManager.time - lastTime) / 1000.0;
			val threadCount = workers.size;
			val workCount = queue.size;
			var allProcessing = true;
			
			// Update WorkThreads
			workers.foreach(w => {
				w.update(time);
				if (!w.isWorking) {
					allProcessing = false;
				}
			});
			
			// Check to see if overloaded with work
			if (threadCount < maxThreads) {
				val nextWork = queue.peek();
				nextWork match {
					case wu:WorkUnit => {
						if (WorkManager.time - wu.getEnqueued > workDelayThreshold) {
							addWorker();
						}
					}
					case _ =>
				}
				
				if ((allProcessing) && (workCount > workLoadThreshold) && (allowOverloading)) {
					addWorker();
				}
			}
		}
	}
	
	private def addWorker() = {
		val w = new WorkThread(this);
		workers.add(w);
		w.init();
	}
	
	def +=(work:() => Unit) = {
		init();
		
		queue.add(work);
	}
	
	def -=(work:() => Unit) = {
		queue.remove(work);
	}
	
	def request():() => Unit = {
		var w = queue.poll();
		var first:Function0[Unit] = null;
		
		do {
			if ((first == w) && (first != null)) {
				queue.add(w);
				return null;
			}
			w match {
				case du:DependentUnit => if (du.isReady()) return du;
				case f:Function0[_] => return f;
				case _ =>
			}
			if (w != null) queue.add(w);
			if (first == null) first = w;
			w = queue.poll();
		} while(w != null)
		
		return null;
	}
	
	def threadCount = workers.size();
}

object WorkManager {
	/**
	 * The default amount of time (in seconds) to delay after exceeding
	 * the maximum thread count before settling the count back down.
	 * 
	 * Default value: 5 minutes
	 */
	val DEFAULT_THREAD_SETTLING = 5.0 * 60.0;
	/**
	 * The threshold that must be achieved or exceeded in the work units
	 * waiting in the queue before another thread is added. This will only
	 * apply to the maxThreads.
	 * 
	 * Default value: 10
	 */
	val DEFAULT_WORK_LOAD_THRESHOLD = 10;
	/**
	 * The time (in seconds) threshold that must be achieved or exceeded on
	 * an item in the normal priority queue for an additional worker thread to be
	 * automatically added. This will only apply up to the maxThreads.
	 * 
	 * Default value: 100 milliseconds
	 */
	val DEFAULT_WORK_DELAY_THRESHOLD = 0.1;
	/**
	 * The amount of time for each ProcessingThread to wait before recycling.
	 * 
	 * Default value: 50 milliseconds
	 */
	val DEFAULT_THREAD_WAIT = 0.05;
	/**
	 * The default starting maximum thread count
	 * 
	 * Default value: 500
	 */
	val DEFAULT_MAX_THREADS = 500;
	/**
	 * The amount of time between iterations of the monitoring thread. This
	 * is what checks to see if a work unit that has a timeout period has been
	 * exceeded and should be terminated. Also, this determines the delay between
	 * checks if the max thread count should be increased.
	 * 
	 * Default value: 100 milliseconds
	 */
	val DEFAULT_MONITORING_DELAY = 0.1;
	/**
	 * If true the thread pool will be allowed to exceed the max thread count temporarily
	 * if the work load is too high. Thread settling value is used to determine when to
	 * release overloading threads once the work-load comes back down to a reasonable amount.
	 * 
	 * Default value: true
	 */
	val DEFAULT_ALLOW_OVERLOADING = true;
	/**
	 * If true the worker threads will yield upon completion of work before looking for
	 * additional work to do. This can keep the CPU load down when there is a steady stream
	 * of work without an end in sight.
	 * 
	 * Default value: true.
	 */
	val DEFAULT_THREAD_YIELDING = true;
	
	private var _time = System.currentTimeMillis();
	
	def time = _time;
}