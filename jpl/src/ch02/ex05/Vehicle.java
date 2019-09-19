package practice02.ex05;

class Vehicles {
	public int speed;
	public int angle;
	public String owner;
}

public class Vehicle {
	public static void main(String[] args) {
		Vehicles axela = new Vehicles();
		Vehicles crown= new Vehicles();

		axela.speed = 120;
		axela.angle = 90;
		axela.owner = "mazda";

		crown.speed = 140;
		crown.angle = 180;
		crown.owner = "toyota";

		System.out.println(axela.speed + ":" +  axela.angle + ":" + axela.owner);
		System.out.println(crown.speed + ":" +  crown.angle + ":" + crown.owner);
	}
}

