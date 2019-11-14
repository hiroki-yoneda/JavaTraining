package jpl.ch10.ex01;

public class ChangeToSpecialChar {
	public String Change(String str) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '\n') {
				s.append('\\');
				s.append('n');
			} else if (c == '\\') {
				s.append('\\');
				s.append('\\');
			} else if (c == '\'') {
				s.append('\\');
				s.append('\'');
			} else if (c == '\"') {
				s.append('\\');
				s.append('\"');
			} else if (c == '\t') {
				s.append('\\');
				s.append('t');
			} else if (c == '\b') {
				s.append('\\');
				s.append('b');
			} else if (c == '\r') {
				s.append('\\');
				s.append('r');
			} else if (c == '\f') {
				s.append('\\');
				s.append('f');
			} else {
				s.append(c);
			}

		}
		return s.toString();
	}
}
