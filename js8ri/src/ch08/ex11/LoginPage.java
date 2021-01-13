package js8ri.ch08.ex11;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class LoginPage {

	public static void main(String[] args) {
		// http://leggiero.sakura.ne.jp/xxxxbasic_auth_testxxxx/
		URL url;
		String user = "kaiin";
		String password = "naisho";
		try {
			url = new URL("http://leggiero.sakura.ne.jp/xxxxbasic_auth_testxxxx/secret/kaiin_page_top.htm");
			URLConnection connection = url.openConnection();
			Base64.Encoder encoder = Base64.getEncoder();
		    String auth = user + ":" + password;
		    auth = encoder.encodeToString(auth.getBytes(StandardCharsets.UTF_8));

		    connection.setRequestProperty("Authorization", "Basic " + auth);
		    connection.connect();
		    System.out.println(connection.getInputStream());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
