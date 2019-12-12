package jpl.ch13.ex01;

public class counter {
	public static final int countSpecificChar(String str, char ch) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(ch == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
