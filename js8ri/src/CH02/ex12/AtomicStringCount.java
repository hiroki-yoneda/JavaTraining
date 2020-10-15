package js8ri.CH02.ex12;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AtomicStringCount {
    public static void main(String[] args){
    	final AtomicInteger[] shortWords = new AtomicInteger[12];
        Arrays.setAll(shortWords, value -> new AtomicInteger(0));
        Stream.of("aaa", "bbbb", "ccccc", "dddddd").parallel().forEach(s -> {
            if (s.length() < 12) {
                shortWords[s.length()].getAndIncrement();
            }
        });
        System.out.println(Arrays.toString(shortWords));
    }
}
