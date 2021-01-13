package js8ri.ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LikeGrep {

	public static void main(String[] args) {
		String path = "src/main/java/js8ri/ch08/ex15/Inquiry_about_room_rate.txt";
		String str = "to";
		Pattern pattern = Pattern.compile(str);
		try(Stream<String> stream = Files.lines(Paths.get(path))){
			stream.filter(pattern.asPredicate())
            .forEach(System.out::println);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
