package js8ri.ch09.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class OprenFile {

	public static void main(String[] args) {
		String input_path = "src/main/java/js8ri/ch09/ex01/input.txt";
		String output_path = "src/main/java/js8ri/ch09/ex01/output.txt";
//		String input_path = "src/main/js8ri/ch09/ex01/input.txt";
//		String output_path = "src/main/java/js8ri/ch10/ex01/output.txt";
		try {
			Scanner in = new Scanner(Paths.get(input_path));
			PrintWriter out = new PrintWriter(output_path);
			try {
				while(in.hasNext()) {
					System.out.println("aaa");
					out.println(in.next().toLowerCase());
				}
			} finally {
				in.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
