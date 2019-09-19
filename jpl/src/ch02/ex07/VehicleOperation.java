package practice02.ex07;

class Vehicle {
	public int speed;
	public int angle;
	public String owner;

	public Vehicle(String owner) {
		this.owner = owner;
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

		System.out.println(axela.speed + ":" +  axela.angle + ":" + axela.owner);
		System.out.println(crown.speed + ":" +  crown.angle + ":" + crown.owner);
	}
}


