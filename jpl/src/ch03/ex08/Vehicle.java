package jpl.ch03.ex08;

/** 条件付きで、Clonable をサポートする。サブクラスから受け取った例外もスローする **/
public class Vehicle implements Cloneable{
	private int speed;
	private int angle;
	private String owner;
	final private int ownId;

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

	static final int getNextId() { return nextId; }

	public final int getOwnId () { return ownId; }

	public final int getSpeed() { return this.speed; }

	public final void setAngle(int angle) { this.angle = angle; }

	public final int getAngle() { return this.angle; }

	public final void setOwner(String owner) { this.owner = owner; }

	public final String getOwner() { return this.owner; }

	public final void changeSpeed(int speed) { this.speed = speed; }

	public final void stop() { this.speed = 0; }

	public Vehicle clone() {
		try {
			return (Vehicle) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}

