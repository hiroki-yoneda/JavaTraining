package jpl.ch13.ex06;

public class Spliter {
	public static String SplitStr(String str, int splitSize, String splitStr) {
		StringBuffer ans = new StringBuffer();
		int index = str.length() % splitSize;
		if(index == 0) {
			index = splitSize;
		}
		ans.append(str.substring(0,  index));

		while(index < str.length()) {
			ans.append(splitStr);
			ans.append(str.substring(index, index + splitSize));
			index += splitSize;
		}
		return ans.toString();
	}
}
