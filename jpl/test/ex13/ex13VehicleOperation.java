package practice02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import practice02.ex13.Vehicle;

public class ex13VehicleOperation {

	@Test
	public void testEx13VehicleOperation() {
		Vehicle axela = new Vehicle("mazda");

		axela.setSpeed(120);
		axela.setAngle(90);

		assertThat(axela.getSpeed(), is(120));
		assertThat(axela.getAngle(), is(90));

	}

}
