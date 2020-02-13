package jpl.ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * 暗号化
 *
 */
public class EncryptOutputStream extends FilterOutputStream {
	static byte key = (byte) 'a';

	protected EncryptOutputStream(OutputStream in) {
		super(in);
	}

	public void write(int b) throws IOException {
		super.write(b ^ key);
	}

}
