package js8ri.ch01.ex03;

import java.io.File;
import java.util.Arrays;

public class ShowFilesFilteredByExt {
	private static String[] getFilesFilteredByExt(File file, String ext){
		return file.list((dir, name) -> name.endsWith("." + ext));
	}

	public static void main(String[] args) {
		String[] files = getFilesFilteredByExt(new File("src/main/java/js8ri/ch01/ex01"), "txt");
		Arrays.stream(files).forEach(System.out::println);
	}
}
