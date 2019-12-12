package jpl.ch13.ex05;

public class Comma {
	public static String AppendComma(String str) {
		StringBuffer ans = new StringBuffer();
		int index = str.length()%3;
		if(index == 0) {
			index=3;
		}
		ans.append(str.substring(0,  index));

		while(index < str.length()) {
			ans.append(",");
			ans.append(str.substring(index, index + 3));
			index += 3;
		}
		return ans.toString();
	}
}
