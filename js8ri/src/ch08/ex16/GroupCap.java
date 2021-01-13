package js8ri.ch08.ex16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupCap {

	public static void main(String[] args) {
		// わからない。。。
		String path = "src/main/java/js8ri/ch08/ex16/Address.txt";
		String str = "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2})";
		Pattern pattern = Pattern.compile(str);
		try {
			for (String line : Files.readAllLines(Paths.get(path))) {
		        Matcher matcher = pattern.matcher(line);
		        if (matcher.matches())
		            continue;
		        System.out.print(matcher.group("city"));
		    }
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
