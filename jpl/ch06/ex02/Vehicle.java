package jpl.ch06.ex02;

class Vehicle {
	private int speed;
	private int angle;
	private String owner;
	final private int ownId;

	final private Turn turn_left = Turn.TURN_LEFT;
	final private Turn turn_right = Turn.TURN_RIGHT;

	private static int nextId = 0;

	public Vehicle() {
		this.ownId = nextId++;
	}

	public Vehicle(String owner) {
		this.ownId = nextId++;
		this.owner = owner;
	}

	public String toString() {
		String desc = speed + ":" +  angle + ":" + owner + ":" + ownId;
		return desc;
	}

	static int getNextId() { return nextId; }

	public int getOwnId () { return ownId; }

	public int getSpeed() { return this.speed; }

	public void setAngle(int angle) { this.angle = angle; }

	public int getAngle() { return this.angle; }

	public void setOwner(String owner) { this.owner = owner; }

	public String getOwner() { return this.owner; }

	public void changeSpeed(int speed) { this.speed = speed; }

	public void stop() { this.speed = 0; }

	public Turn getTurn() {
		Turn turn = null;
		/* 回転する角度が
		 * 負の場合は、左回転
		 * 正の場合は、右回転 */
		if (this.angle < 0) {
			turn = turn_left;
		} else {
			turn = turn_right;
		}
		return turn;
	}

	/* 定数を引数にとるメソッドがよくわかりませんでした */
}
