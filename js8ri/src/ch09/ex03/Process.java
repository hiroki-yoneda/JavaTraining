package js8ri.ch09.ex03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class Process {
	public void process(boolean flag) throws FileNotFoundException, UnknownHostException {
		try {
			if (flag) {
				throw new FileNotFoundException();
			} else {
				throw new UnknownHostException();
			}
		} catch (FileNotFoundException | UnknownHostException ex) {
	        throw ex;
		}
	}

	public static void main(String[] args) {
		Process process = new Process();
		boolean flag = true;
		try {
			process.process(flag);
		} catch (FileNotFoundException | UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
