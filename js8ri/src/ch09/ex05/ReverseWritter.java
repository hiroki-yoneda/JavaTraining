package js8ri.ch09.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseWritter {

	public static void main(String[] args) {
		String in_path = "src/main/java/js8ri/ch09/ex05/input.txt";
		String out_path = "src/main/java/js8ri/ch09/ex05/out.txt";
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(in_path));
			StringBuilder in = new StringBuilder(new String(bytes, StandardCharsets.UTF_8));
			in.reverse();
			Files.write(Paths.get(out_path), in.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
