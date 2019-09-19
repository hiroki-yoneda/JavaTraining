package practice02.ex10;

class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	final public int ownId;

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

	static int getNextId() {
		return nextId;
	}

}

public class VehicleOperation {
	public static void main(String[] args) {
		Vehicle axela = new Vehicle("mazda");
		Vehicle crown= new Vehicle("toyota");

		axela.speed = 120;
		axela.angle = 90;

		crown.speed = 140;
		crown.angle = 180;

		System.out.println("Vehicle " + axela);
		System.out.println(crown);
	}
}
