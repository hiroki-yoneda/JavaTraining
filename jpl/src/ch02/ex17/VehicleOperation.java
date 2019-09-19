package practice02.ex17;

class Vehicle {
	private int speed;
	private int angle;
	private String owner;
	final private int ownId;

	final private String TURN_LEFT = "Left";
	final private String TURN_RIGHT = "Right";

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

	public String turn(int angle) {
		String turn;
		/* 回転する角度が
		 * 負の場合は、左回転
		 * 正の場合は、右回転 */
		if (angle < 0) {
			turn = TURN_LEFT;
		} else {
			turn = TURN_RIGHT;
		}
		return turn;
	}

	/* 定数を引数にとるメソッドがよくわかりませんでした */
}

public class VehicleOperation {
	public static void main(String[] args) {
		Vehicle axela = new Vehicle("mazda");

		axela.changeSpeed(90);
		System.out.println(axela.getSpeed());
		axela.changeSpeed(120);
		System.out.println(axela.getSpeed());
		axela.stop();
		System.out.println(axela.getSpeed());
	}
}
