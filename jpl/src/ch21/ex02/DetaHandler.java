package jpl.ch21.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.WeakHashMap;

class DataHandler {
	private WeakHashMap<File, byte[]> lastData; // 読み込んだファイルとデータのキャッシュ

	byte[] readFile(File file) {
		byte[] data;
		// データを記憶しているか調べる
		if (lastData != null && lastData.get(file) != null) {
			data = lastData.get(file);
			if (data != null)
				return data;
		}
		// 記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastData = new WeakHashMap<>();
		lastData.put(file, data);
		return data;
	}

	byte[] readBytesFromFile(File file) {
		byte[] bytes = new byte[(int) file.length()];
		try (FileInputStream fileIn = new FileInputStream(file);) {
			fileIn.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}
}
