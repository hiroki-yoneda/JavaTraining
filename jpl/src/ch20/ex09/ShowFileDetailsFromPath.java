package jpl.ch20.ex09;

import java.io.File;

public class ShowFileDetailsFromPath {
	final private static String filePath = "ch20/ex09/resource.txt";

	static void showFileDetails(String path){
		File file = new File(path);
		System.out.println("absolute path: " + file.getAbsolutePath());
		System.out.println("name: " + file.getName());
		System.out.println("can read: " + file.canRead());
		System.out.println("can write: " + file.canWrite());
		System.out.println("parent: " + file.getParent());
		System.out.println("path: " + file.getPath());
	}
	public static void main(String[] args ){
		showFileDetails(filePath);
	}
}
