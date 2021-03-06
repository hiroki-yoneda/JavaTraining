package jpl.ch02.ex18;

class Vehicle {
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

	static int getNextId() { return nextId; }

	public int getOwnId () { return ownId; }

	public int getSpeed() { return this.speed; }

	public void setAngle(int angle) { this.angle = angle; }

	public int getAngle() { return this.angle; }

	public void setOwner(String owner) { this.owner = owner; }

	public String getOwner() { return this.owner; }

	public void changeSpeed(int speed) { this.speed = speed; }

	public void stop() { this.speed = 0; }

}

public class VehicleOperation {
	public static void main(String[] args) {
		Vehicle axela = new Vehicle(args[0]);
		System.out.println(makeMessage(axela));
	}

	static String makeMessage(Vehicle vehicle) {
        return vehicle.getOwner();
    }
}
