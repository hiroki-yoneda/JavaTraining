package jpl.ch06.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTrunTest {
	@Test
	public void TrunVehicle() {
		Vehicle axela = new Vehicle("mazda");
		axela.setAngle(-50);
		axela.getAngle();
		assertThat(axela.getTurn(), is(Turn.TURN_LEFT));
		axela.setAngle(50);
		axela.getAngle();
		assertThat(axela.getTurn(), is(Turn.TURN_RIGHT));
	}

}
