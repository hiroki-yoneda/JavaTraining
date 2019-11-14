package jpl.ch02.ex15;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class ex15VehicleOperationTest {

	@Test
	public void testEx0LinkedList() {
		Vehicle axela = new Vehicle("mazda");
		axela.changeSpeed(90);
		axela.stop();
		assertThat(axela.getSpeed(), is(0));
	}

}
