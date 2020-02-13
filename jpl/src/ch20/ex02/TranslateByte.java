package jpl.ch20.ex02;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByte extends FilterInputStream{
	protected TranslateByte(InputStream in) {
		super(in);
	}

	public int read(byte from, byte to) throws IOException {
		int c = super.read();
		if (c == -1) {
			return -1;
		}
		return c == from ? to : c;
	}

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("src/main/java/jpl/ch20/ex02/" + args[0]);
		byte from = (byte) args[1].charAt(0);
		byte to   = (byte) args[2].charAt(0);
		TranslateByte tb = new TranslateByte(in);
		int b;
		while((b = tb.read()) != -1) {
			System.out.write(b == from ? to :b);
		}
		tb.close();
	}
}
