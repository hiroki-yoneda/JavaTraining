package jpl.ch13.ex02;

public class counter {
	public static final int countSpecificStr(String str, String target) {
		int hasTargetIndex = str.indexOf(target);
		if(hasTargetIndex >= 0 ) {
			return countSpecificStr(str.substring(hasTargetIndex + target.length()), target) + 1;
		}
	return 0;
	}
}
