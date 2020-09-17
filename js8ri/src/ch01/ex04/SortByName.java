package js8ri.ch01.ex04;

import java.io.File;
import java.util.Arrays;

public class SortByName {
	private static void sortByName(File[] files) {
		Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getPath().compareTo(f2.getPath());
            }
        });
	}

	public static void main(final String[] args) {
        File[] files = {new File("a/b.txt"), new File("b/a.txt"), new File("c/d.txt"), new File("d/c")};
        sortByName(files);
        Arrays.stream(files).forEach(file -> System.out.println(file.getPath()));
    }
}
