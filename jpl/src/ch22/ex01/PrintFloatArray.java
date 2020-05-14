package jpl.ch22.ex01;

public class PrintFloatArray {
	public static void printFloatArray(float[] floats, int num) {
		int count = 0;
		for (float f : floats) {
			System.out.printf("%1$10.3g", f);
			count++;
			if (count == num) {
				System.out.println();
				count = 0;
			}
		}
	}
}
