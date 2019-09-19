package practice01;

import practice01.WalkmanFolder.TwoCommunicationWalkman;

/* WalkmanFolder に設計したクラスあり
 * Walkman.java 1端子
 * TwoTerminalWalkman.java ２端子
 * TwoCommunicationWalkman.java コミュニケーション機能
 * */
public class Practice0114 {

	public static void main(String[] args) {
		TwoCommunicationWalkman twoComWalkman = new TwoCommunicationWalkman();
		twoComWalkman.terminal();
		twoComWalkman.setChat("hoge", "fuga");
		twoComWalkman.printCommuni();
	}

}
