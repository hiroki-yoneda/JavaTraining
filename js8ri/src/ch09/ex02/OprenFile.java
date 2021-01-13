package js8ri.ch09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class OprenFile {

	public static void main(String[] args) {
		// ???

		String input_path = "src/main/java/js8ri/ch09/ex01/input.txt";
		String output_path = "src/main/java/js8ri/ch09/ex01/output.txt";
//		String input_path = "src/main/js8ri/ch09/ex01/input.txt";
//		String output_path = "src/main/java/js8ri/ch10/ex01/output.txt";
		try {
			Scanner in = new Scanner(Paths.get(input_path));
			PrintWriter out = new PrintWriter(output_path);
			try {
				while(in.hasNext()) {
					out.println(in.next().toLowerCase());
				}
			} catch (IllegalStateException e){
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
