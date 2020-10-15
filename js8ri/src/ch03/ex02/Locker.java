package js8ri.ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class Locker {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
        withLock(lock, () -> System.out.println("Locked"));
	}

	public static void withLock(ReentrantLock myLock, Runnable runnable) {
        myLock.lock();
        try {
            runnable.run();
        } finally {
            myLock.unlock();
        }
    }
}
