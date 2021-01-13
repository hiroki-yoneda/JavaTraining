package js8ri.ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SaveWeb {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://www.google.com/");
			try (InputStream stream = url.openStream()) {
			    Files.copy(stream, Paths.get("src/main/java/js8ri/ch09/ex07/google.html"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
