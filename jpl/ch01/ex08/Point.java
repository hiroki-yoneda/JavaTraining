package jpl.ch01.ex08;

public class Point {
	double x,y;

	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void clear() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public void setCoordinate(Point that) {
		this.x = that.x;
		this.y = that.y;
	}

	/* 確認用 */
	public void printCoordinate() {
		System.out.println("x: " + this.x + " y: " + this.y);
	}

}
