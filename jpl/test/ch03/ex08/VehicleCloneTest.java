package jpl.ch03.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleCloneTest {

	@Test
	public void sucClone() {
		Vehicle vehicle = new Vehicle();
		vehicle.setOwner("MAZDA");
		Vehicle clonedVehicle = vehicle.clone();
		assertThat(clonedVehicle.getOwner(), is("MAZDA"));
	}

	@Test
	public void notSameObject() {
		Vehicle vehicle = new Vehicle();
		Vehicle clonedVehicle = vehicle.clone();
		assertNotSame(clonedVehicle, vehicle);
	}

}
