package jpl.ch13.ex03;

import java.util.ArrayList;
import java.util.List;

public class DelimitedString {
	public static List<String> delimitedString(String from, char start, char end) {
		List<String> list = new ArrayList<String>();
		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);

		if (startPos == -1 || startPos > endPos) {
			return null;
		}

		list.add(from.substring(0, startPos + 1));
		if (endPos == -1) {
			list.add(from.substring(startPos + 1));
			return list;
		}
		list.add(from.substring(startPos + 1, endPos + 1));
		list.add(from.substring(endPos + 1));
		return list;
	}
}
