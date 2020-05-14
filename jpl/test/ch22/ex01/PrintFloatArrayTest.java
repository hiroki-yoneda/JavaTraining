package jpl.ch22.ex01;

import org.junit.Test;

public class PrintFloatArrayTest {
	@Test
	public void showFloat() {
		PrintFloatArray.printFloatArray(new float[] { 3.14f, 202f, -111f, -1.0839f, 0.23f,
				2020f, 7.33f, 111f, 9837f, 0.12803721f }, 3);
	}
}
