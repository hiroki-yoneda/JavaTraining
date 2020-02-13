package jpl.ch20.ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByte {

	public static void main(String[] args) {
		InputStream in = null; // ここまずい
		if (args.length == 0) {
			in = System.in; // ここの処理変える
		} else {
			try {
				in = new FileInputStream("src/main/java/jpl/ch20/ex01/" + args[0]);
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		byte from = (byte) args[1].charAt(0);
		byte to   = (byte) args[2].charAt(0);
		int b;
		try {
			while((b = in.read()) != -1) {
				System.out.write(b == from ? to : b);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
