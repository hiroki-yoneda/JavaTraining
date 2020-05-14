package jpl.ch22.ex06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GaussianGlaph {
	private static final double HISTOGRAM_SIZE = 0.1;
	private static final double X_MIN = -2.5;
	private static final double X_MAX = 2.5;

	public static void showHistogram(int times) {
		Map<Integer, Integer> histogramMap = new HashMap<>();
		Random r = new Random();
		for (int i = 0; i < times; i++) {
			double d = r.nextGaussian();
			int index = (int) Math.round(d / HISTOGRAM_SIZE);
			Integer count = histogramMap.get(index);
			if (count == null) {
				count = 0;
			}
			histogramMap.put(index, count + 1);
		}
		for (int i = 0; i <= ((X_MAX - X_MIN)/HISTOGRAM_SIZE); i++) {
			Integer count = histogramMap.get((int) ((X_MIN + (i * HISTOGRAM_SIZE))/ HISTOGRAM_SIZE));
			System.out.print(String.format("%.1f: ", (X_MIN + (i * HISTOGRAM_SIZE))));
			if (count == null) {
				count = 0;
			}
			for (int j = 0; j < count; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		showHistogram(1000);
	}
}