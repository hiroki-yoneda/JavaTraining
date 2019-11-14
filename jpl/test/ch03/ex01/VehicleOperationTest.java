package jpl.ch03.ex01;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpl.ch03.ex01.VehicleOperation;

// https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
public class VehicleOperationTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}

	@Test
	public void out() {
	    VehicleOperation.main(null);
	    assertEquals("Seats:5  Passengers:2\n" + "Seats:5  Passengers:4\n" + "", outContent.toString());
	}
}
