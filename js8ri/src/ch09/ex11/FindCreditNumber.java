package js8ri.ch09.ex11;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FindCreditNumber {
	public static void findCreditNum() throws InterruptedException, IOException {
		ProcessBuilder builder = new ProcessBuilder("grep", "-r", "[0-9]{16}", "./");
		builder.inheritIO().start().waitFor(1, TimeUnit.MINUTES);
	}

	public static void main(String[] args) {
		try {
			findCreditNum();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
