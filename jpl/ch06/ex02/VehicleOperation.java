package jpl.ch06.ex02;

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
