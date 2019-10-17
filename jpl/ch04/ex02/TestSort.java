package jpl.ch04.ex02;

public class TestSort {
	static String[] testData = {
			"a","B","c","E79","03.17"
	};

	public static void main(String[] args) {
		SortHerness bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
//		//脆弱性
//		metrics.probeCnt = 7;
//		metrics.compareCnt = 7;
//		metrics.swapCnt = 7;
		System.out.println("Metrics:" + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}
