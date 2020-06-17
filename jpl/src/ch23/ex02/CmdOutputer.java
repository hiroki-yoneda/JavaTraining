package jpl.ch23.ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CmdOutputer {

	private static List<String> execution(String[] cmd) {
		try {
			Process child = Runtime.getRuntime().exec(cmd);
			InputStream isOut = child.getInputStream();
			InputStreamReader r = new InputStreamReader(isOut);
			LineNumberReader l = new LineNumberReader(r);

			List<String> lines = new ArrayList<String>();
			String line;
			while((line = l.readLine()) != null) {
				lines.add(l.getLineNumber() + ": " + line);
			}
			if (child.waitFor() != 0) {
				throw new IOException("Command is failure." + child.exitValue());
			}
			return lines;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static void main(String args[]) {
		List<String> resultList = execution(args);
		resultList.forEach(System.out::println);
	}
}
