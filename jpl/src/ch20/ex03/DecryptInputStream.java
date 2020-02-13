package jpl.ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 復号化
 *
 */
public class DecryptInputStream extends FilterInputStream{
	static byte key = (byte) 'a';

	protected DecryptInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException {
		int b = super.read();
		return b == -1 ? b : b ^ key;
	}
}
