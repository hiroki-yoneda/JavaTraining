package jpl.ch14.ex06;

public class PrintMessage extends Thread {
	int second;

	PrintMessage(int second) {
		this.second = second;
	}

	public void run() {
		synchronized (this) {
			while (true)
				try {
					wait(second * 1000);
					System.out.println(second + "の倍数秒経過");
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
	}
}
