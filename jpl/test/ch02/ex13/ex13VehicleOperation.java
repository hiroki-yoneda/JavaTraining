package jpl.ch02.ex13;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

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
