package jpl.ch10.ex02;

public class ChangeToSpecialChar {
	public String Change(String str) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			switch (c){
			case '\t':
				s.append('\\');
				s.append('t');
				break;
			case '\b':
				s.append('\\');
				s.append('b');
				break;
			case '\r':
				s.append('\\');
				s.append('r');
				break;
			case '\f':
				s.append('\\');
				s.append('f');
				break;
			case '\n':
				s.append('\\');
				s.append('n');
				break;
			case '\\':
				s.append('\\');
				s.append('\\');
				break;
			case '\'':
				s.append('\\');
				s.append('\'');
				break;
			case '\"':
				s.append('\\');
				s.append('\"');
				break;
			default:
				s.append(c);
			}
		}
		return s.toString();
	}
}

