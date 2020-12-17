package js8ri.ch06.ex07;

import java.util.concurrent.ConcurrentHashMap;

public class FindMaxValueKey {
	static ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<String, Long>() {
		{
			put("apple", 3L);
			put("orange", 2L);
			put("lemon", 4L);
			put("Grape", 1L);
		}
	};

	public static void main(String[] args) {
		String maxValueKey = concurrentHashMap.reduceEntries(2, (f1, f2) -> f1.getValue().compareTo(f2.getValue()) > 0 ? f1 : f2).getKey();
		System.out.println(maxValueKey);
	}
}
