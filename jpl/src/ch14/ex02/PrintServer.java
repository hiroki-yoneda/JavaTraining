package jpl.ch14.ex02;

import java.awt.PrintJob;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private final long threadId;

	public PrintServer() {
		Thread thisThread = new Thread(this);
		threadId = thisThread.getId();
		thisThread.start();
	}
	public void run() {
		if(Thread.currentThread().getId() != threadId) {
			return;
		}
		for(;;) {
			realPrint(requests.remove());
		}
	}
	private void realPrint(PrintJob job) {
		//印刷の実際の処理を行う
	}
}
