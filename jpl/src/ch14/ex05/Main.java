package jpl.ch14.ex05;

public class Main implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Calculator.add();
			Calculator.minus();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		Thread thread01 = new Thread(main);
		Thread thread02 = new Thread(main);

		thread01.start();
		thread02.start();
	}
}
