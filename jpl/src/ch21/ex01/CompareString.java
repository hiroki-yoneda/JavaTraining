package jpl.ch21.ex01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareString {
	public static void main(String[] args) {

		final LinkedList<String> sortedList = new LinkedList<>();
		// https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java
		try (Stream<String> stream = Files.lines(Paths.get("src/main/java/jpl/ch21/ex01/test.txt"))) {
			final List<String> strList = stream.collect(Collectors.toList());

			for (String str : strList) {
				int index = 0;
				for (String sortedStr : sortedList) {
					if (str.compareTo(sortedStr) < 0) {
						sortedList.add(index, str);
						break;
					}
					index++;
				}
				if (index == sortedList.size()) {
					sortedList.addLast(str);
				}
			}
			sortedList.forEach(System.out::println);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
