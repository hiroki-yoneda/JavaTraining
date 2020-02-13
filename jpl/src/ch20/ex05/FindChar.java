package jpl.ch20.ex05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindChar {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			throw new IllegalArgumentException("need char and file");
		}

		int match = args[1].charAt(0);
		FileReader fileIn = new FileReader("src/main/java/jpl/ch20/ex05/" + args[0]);
		LineNumberReader in = new LineNumberReader(fileIn);
		int ch;
		while ((ch = in.read()) != -1) {
			if (ch == match) {
				System.out.println("'" + (char) ch + "' at line " + in.getLineNumber());
			}
		}
		in.close();
	}
}
