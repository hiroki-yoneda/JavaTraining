package js8ri.ch06.ex08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EvalSortPerform {

	public static Long parallelSort(int[] intArray) {
		int[] clonedArray = intArray.clone();
		long startTime = System.nanoTime();
		Arrays.sort(clonedArray);
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

	public static Long serialSort(int[] intArray) {
		int[] clonedArray = intArray.clone();
		long startTime = System.nanoTime();
		Arrays.parallelSort(clonedArray);
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

	public static List<Integer> createRandomList(int listSize) {
		Random rand = new Random();
		List<Integer> integerList = new ArrayList<>();
		for (int i=0; i<listSize; i++ ) {
			integerList.add(rand.nextInt(1000));
		}
		return integerList;
	}

	public static void main(String[] args) {
		Long serialTime = 0L;
		Long parallelTime = 0L;
		int listSize = 5;

		while(parallelTime >= serialTime) {
			int[] intArray = createRandomList(listSize).stream().mapToInt(i -> i).toArray();
		    serialTime = serialSort(intArray);
			parallelTime = parallelSort(intArray);
			System.out.println("ListSize: " + listSize + " " + "Sort: " + serialTime + " ns " + " ParallelTime: " + parallelTime + " ns");
			listSize++;
		}
	}
}
