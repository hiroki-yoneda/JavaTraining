package jpl.ch14.ex03;

public class Main implements Runnable {

	Calculator calculator;

	public Main(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			calculator.add();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Main main = new Main(calculator);
		Thread thread01 = new Thread(main);
		Thread thread02 = new Thread(main);

		thread01.start();
		thread02.start();
	}
}
