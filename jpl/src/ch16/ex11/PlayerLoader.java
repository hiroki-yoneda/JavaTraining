package jpl.ch16.ex11;

import java.io.FileInputStream;
import java.io.IOException;

class PlayerLoader extends ClassLoader {
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] buf = bytesForClass(name);
			return defineClass(name, buf, 0, buf.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(e.toString());
		}
	}

	protected byte[] bytesForClass(String name) throws IOException {
		FileInputStream in = null;
		try {
			in = streamFor(name + ".class");
			int length = in.available(); // バイト数を得る
			if (length == 0)
				throw new ClassNotFoundException(name);
			byte[] buf = new byte[length];
			in.read(buf);
			return buf;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
		return new byte[0];
	}

	protected FileInputStream streamFor(String name) {
		try (FileInputStream file = new FileInputStream("src/main/resource" + name)) {
			return file;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
