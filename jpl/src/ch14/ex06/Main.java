package jpl.ch14.ex06;

public class Main extends Thread{
	int count = 0;

	public void run(){
		try {
			for(int i = 0; i < 20; i++){
				System.out.println(count + "秒");
				count++;
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Main thread01 = new Main();
		PrintMessage thread02 = new PrintMessage(7);
		PrintMessage thread03 = new PrintMessage(15);
		thread01.start();
		thread02.start();
		thread03.start();
	}
}
