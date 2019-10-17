package jpl.ch01.ex08;

public class Practice0108 {

	public static void main(String[] args) {
		Point coorA = new Point();
		Point coorB = new Point();

		/* 座標のセット */
		coorA.move(1.0, 2.0);
		coorB.move(3.0, 4.0);

		/* coorBオブジェクトの座標をcoorAオブジェクトにセットする */
		coorA.setCoordinate(coorB);
		/* 表示 */
		coorA.printCoordinate();
	}
}
