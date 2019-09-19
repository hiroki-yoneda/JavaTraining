package practice02.ex06;

import java.util.LinkedList;

import practice02.ex01.Vehicle;

public class LinkedListTest {

	public static void main(String[] args) {
		Vehicle axela = new Vehicle();
		Vehicle crown= new Vehicle();

		axela.speed = 120;
		axela.angle = 90;
		axela.owner = "mazda";

		crown.speed = 140;
		crown.angle = 180;
		crown.owner = "toyota";

		LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();
		vehicleList.add(axela);
		vehicleList.add(crown);

		for(int i = 0; i < vehicleList.size(); i++) {
			System.out.println(vehicleList.get(i).speed);
			System.out.println(vehicleList.get(i).angle);
			System.out.println(vehicleList.get(i).owner);
		}
	}

}
