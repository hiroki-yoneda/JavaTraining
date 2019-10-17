package jpl.ch02.ex09;

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

	/*  */
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

		System.out.println(axela.speed + ":" +  axela.angle + ":" + axela.owner + ":" + axela.ownId);
		System.out.println(crown.speed + ":" +  crown.angle + ":" + crown.owner + ":" + crown.ownId);

		System.out.println(Vehicle.getNextId());
	}
}

