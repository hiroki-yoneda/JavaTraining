package jpl.ch03.ex09;

import java.util.ArrayList;

import jpl.ch03.ex08.Vehicle;

public class Garage implements Cloneable {
	private ArrayList<Vehicle> garage = new ArrayList<Vehicle>();

	public void addVehicle(Vehicle vehicle) {
		garage.add(vehicle);
	}

	public ArrayList<Vehicle> getGarage() {
		return garage;
	}

	public Garage clone() {
		Garage clonedGarage = new Garage();
		for (Vehicle g : this.garage){
            clonedGarage.addVehicle(g.clone());
        }
		return clonedGarage;
	}
}
