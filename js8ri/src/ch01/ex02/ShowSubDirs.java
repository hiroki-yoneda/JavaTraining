package js8ri.ch01.ex02;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ShowSubDirs {
	private static List<File> getSubDirsMethodRef(File file){
		File[] subDirs = file.listFiles(File::isDirectory);
		return Arrays.asList(subDirs);
	}

	private static List<File> getSubDirLambda(File file){
		File[] subDirs = file.listFiles(lf -> lf.isDirectory());
		return Arrays.asList(subDirs);
	}

	public static void main(String[] args) {
		getSubDirsMethodRef(new File("src/main")).forEach(System.out::println);
		getSubDirLambda(new File("src/main")).forEach(System.out::println);
	}
}
