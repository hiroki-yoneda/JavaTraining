package jpl.ch23.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CmdOutputer {

	private static List<String> execution(String[] cmd, String quitWord) {
		try {
			Process child = Runtime.getRuntime().exec(cmd);
			InputStream isOut = child.getInputStream();
			InputStreamReader r = new InputStreamReader(isOut);
			LineNumberReader l = new LineNumberReader(r);

			List<String> lines = new ArrayList<String>();
			String line;
			while((line = l.readLine()) != null) {
				if (line.contains(quitWord)) {
					lines.add(l.getLineNumber() + ": this line has quit word.");
					break;
				}
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
		String quitWord = "quit";
		List<String> resultList = execution(args, quitWord);
		resultList.forEach(System.out::println);
	}
}
