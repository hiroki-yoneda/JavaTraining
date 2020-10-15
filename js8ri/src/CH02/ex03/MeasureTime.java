package js8ri.CH02.ex03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

// eigo-samples.com/hotel-booking/g-room-rate.html
public class MeasureTime {
	public static void main(String[] args) throws IOException {
		List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("src/main/java/js8ri/CH02/ex03/Inquiry_about_room_rate.txt"))
                ).split("[\\P{L}]+")
        );
		long start = System.nanoTime();
		long count = words.parallelStream().filter(s -> s.length() > 5).count();
        long end = System.nanoTime();
        System.out.println("count : " + count + " Time : " + (end - start) + " nanosecond");
	}
}
