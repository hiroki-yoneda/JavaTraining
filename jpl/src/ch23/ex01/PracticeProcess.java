package jpl.ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PracticeProcess {
	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	// 子プロセスの標準入力を親プロセスの標準出力に
	private static void plugTogether(InputStream in, OutputStream out) {
		Thread thread = new Thread() {
			public void run() {
				try {
					int i;
					while ((i = in.read()) != -1) {
						out.write(i);
					}
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}

	// 子プロセスの標準出力を親プロセスの標準入力に
	private static void plugTogether(OutputStream out, InputStream in) {
		Thread thread = new Thread() {
			public void run() {
				try {
					int i;
					while ((i = in.read()) != -1) {
						out.write(i);
					}
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
}
