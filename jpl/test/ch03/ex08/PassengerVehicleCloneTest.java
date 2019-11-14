package jpl.ch03.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleCloneTest {

	@Test
	public void sucClone() {
		PassengerVehicle passengerVehicle = new PassengerVehicle();
		passengerVehicle.setSeatsNum(4);
		passengerVehicle.setPassengerNum(3);
		PassengerVehicle clonedPassengerVehicle = passengerVehicle.clone();
		assertThat(clonedPassengerVehicle.getSeatsNum(), is(passengerVehicle.getSeatsNum()));
		assertThat(clonedPassengerVehicle.getPassengerNum(), is(passengerVehicle.getPassengerNum()));
	}

	@Test
	public void notSameObject() {
		PassengerVehicle passengerVehicle = new PassengerVehicle();
		PassengerVehicle clonedPassengerVehicle = passengerVehicle.clone();
		assertNotSame(clonedPassengerVehicle, passengerVehicle);
	}

	@Test
	public void failClone() {
		// CloneNotSupportedException をスロー
	}
}
