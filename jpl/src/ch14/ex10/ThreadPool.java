package jpl.ch14.ex10;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.<br><br>
 *
 * [Instruction]
 * <ul>
 *  <li> Implement one constructor and three methods. </li>
 *  <li> Don't forget to write a Test program to test this class. </li>
 *  <li> Pay attention to @throws tags in the javadoc. </li>
 *  <li> If needed, you can put "synchronized" keyword to methods. </li>
 *  <li> All classes for implementation must be private inside this class. </li>
 *  <li> Don't use java.util.concurrent package. </li>
 *  <li> Don't use {@link java.lang.Thread#interrupt}  method to stop a thread</li>
 *  </ul>
 *
 *  @author Hiroki Yoneda
 */

// https://www.ibm.com/developerworks/jp/java/library/j-jtp0730/index.html
public class ThreadPool {
	private final WorkerThread[] workingThreads;
	private final Queue queue;
	//	private final LinkedList<Runnable> queue;
	//	private final int queueSize;
	private volatile boolean isStarted = false;

	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize the max size of queue
	 * @param numberOfThreads the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException if either queueSize or numberOfThreads
	 *         is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1) {
			throw new IllegalArgumentException("queueSize must be larger than 0.");
		}
		if (numberOfThreads < 1) {
			throw new IllegalArgumentException("numberOfThreads must be larger than 0.");
		}
		workingThreads = new WorkerThread[numberOfThreads];
		queue = new Queue(queueSize);
		//    	queue = new LinkedList<Runnable>();
		//    	this.queueSize = queueSize;
		for (int i = 0; i < numberOfThreads; i++) {
			workingThreads[i] = new WorkerThread();
		}
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException if threads has been already started.
	 */
	public void start() {
		if (isStarted) {
			throw new IllegalStateException("Thread has been already started.");
		}
		for (WorkerThread workerThread : workingThreads) {
			workerThread.start();
		}
		isStarted = true;
	}

	/**
	 * Stop all threads gracefully and wait for their terminations.
	 * All requests dispatched before this method is invoked must complete
	 * and this method also will wait for their completion.
	 *
	 * @throws IllegalStateException if threads has not been started.
	 */
	public void stop() {
		if (!isStarted) {
			throw new IllegalStateException("Thread is not started.");
		}
		for (WorkerThread workerThread : workingThreads) {
			workerThread.requestStop();
			queue.notifyAllByStop();
			// workingThreadクラスの処理が終了するまで待機
			try {
				workerThread.join();
			} catch (InterruptedException ignored) {
			}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool.
	 * run() method will be invoked in the thread. If the queue is full, then
	 * this method invocation will be blocked until the queue is not full.
	 *
	 * @param runnable Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException if runnable is null.
	 * @throws IllegalStateException if this pool has not been started yet.
	 */
	public void dispatch(Runnable runnable) {
		Optional.ofNullable(runnable).orElseThrow(() -> new NullPointerException());
		if (!isStarted) {
			throw new IllegalStateException("Thread is not started.");
		}
		queue.add(runnable);
		//    	synchronized (queue) {
		//			while (queue.size() >= this.queueSize) {
		//				try {
		//					wait();
		//				} catch (InterruptedException ignored) {
		//				}
		//			}
		//			queue.add(runnable);
		//			notifyAll();
		//		}
	}

	public class WorkerThread extends Thread {
		private volatile boolean isStopped = false;

		@Override
		public void run() {
			Runnable task;
			while (!isStopped) {
				task = queue.poll();
				//    			synchronized (queue) {
				//					while (queue.isEmpty()) {
				//						try {
				//                          // illegalmonitorstateexception
				// 							// wait, notifyAll 共、必ず this のモニタに入った状態 (synchronized メソッドを実行した状態) でなければ実行できないことに注意する必要がある。
				//							// これを守らないと、java.lang.IllegalMonitorStateException がスローされる。
				//							// https://java2005.cis.k.hosei.ac.jp/materials/lecture26/multithreaded.html
				//							wait();
				//						} catch (InterruptedException ignored) {
				//						}
				//					}
				//					task = (Runnable) queue.poll();
				//					notifyAll();
				//				}
				if (task != null) {
					task.run();
				}
			}
		}

		public void requestStop() {
			isStopped = true;
		}
	}

	public static class Queue {
		private final int queueSize;
		private LinkedList<Runnable> queue;

		public Queue(int queueSize) {
			this.queueSize = queueSize;
			queue = new LinkedList<>();
		}

		synchronized public void add(Runnable runnable) {
			if (queue.size() >= this.queueSize) {
				try {
					wait();
				} catch (InterruptedException ignored) {
				}
			}
			queue.add(runnable);
			notifyAll();
		}

		synchronized public Runnable poll() {
			if (queue.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException ignored) {
				}
			}
			Runnable runnable = queue.poll();
			notifyAll();
			return runnable;
		}

		synchronized public void notifyAllByStop() {
			notifyAll();
		}
	}
}
