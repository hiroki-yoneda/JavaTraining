package jpl.ch03.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch03.ex08.Vehicle;

public class GarageTest {

	@Test
	public void sucClone() {
		Vehicle Mazda = new Vehicle("Mazda");
		Vehicle Toyota = new Vehicle("Toyota");
		Garage garage = new Garage();
		garage.addVehicle(Mazda);
		garage.addVehicle(Toyota);
		Garage clonedGarage = garage.clone();
		assertEquals(clonedGarage.getGarage().toString(), garage.getGarage().toString());
	}

	@Test
	public void changeElement() {
		Vehicle Mazda = new Vehicle("Mazda");
		Vehicle Toyota = new Vehicle("Toyota");
		Garage garage = new Garage();
		garage.addVehicle(Mazda);
		garage.addVehicle(Toyota);
		Garage clonedGarage = garage.clone();
		clonedGarage.getGarage().get(1).setOwner("Suzuki");;
		assertNotSame(clonedGarage.getGarage().toString(), garage.getGarage().toString());
	}
}
