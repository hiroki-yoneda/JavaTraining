package js8ri.ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReverseWritter {

	public static void main(String[] args) {
		String in_path = "src/main/java/js8ri/ch09/ex06/input.txt";
		String out_path = "src/main/java/js8ri/ch09/ex06/out.txt";
		try {
			List<String> lines = Files.readAllLines(Paths.get(in_path));
			Collections.reverse(lines);
			Files.write(Paths.get(out_path), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
