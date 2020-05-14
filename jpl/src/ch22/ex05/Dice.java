package jpl.ch22.ex05;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dice {
	public static void showHistogram(int times) {
		Map<Integer, Integer> probabilityMap = new HashMap<>();
		Random r = new Random();
		for (int i = 0; i < times; i++) {
			int d = r.nextInt(6) + 1;
			Integer count = probabilityMap.get(d);
			if (count == null) {
				count = 0;
			}
			probabilityMap.put(d, count + 1);
		}
		for (int i = 0; i < 6; i++) {
			int diceNum = i + 1;
			System.out.println(diceNum + ": " + (probabilityMap.get(i+1)/(times/100)) + "%");
		}
	}

	public static void main(String[] args) {
		showHistogram(1000);
	}
}
