package jpl.ch06.ex04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TrafficLightsTest {

	@Test
	public void TrafficLights() {
		TrafficLights redLight = TrafficLights.RED;
		assertThat(redLight.getColor(), is("RED"));

		TrafficLights yellowLights = TrafficLights.YELLOW;
		assertThat(yellowLights.getColor(), is("YELLOW"));

		TrafficLights greenLights = TrafficLights.GREEN;
		assertThat(greenLights.getColor(), is("GREEN"));
	}
}
