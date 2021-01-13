package js8ri.ch08.ex09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LineScanner {

	public static <T> Stream<T> createStream(Iterator<T> iterator){
		Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);
		return StreamSupport.stream(spliterator, false);
	}

	public static Stream<String> wordStream(Scanner scanner){
		return createStream(scanner);
	}

	public static Stream<String> lineStream(Scanner scanner) {
	    Iterator<String> iterator = new Iterator<String>() {
	        public String next() {
	            return scanner.nextLine();
	        }
	        public boolean hasNext() {
	            return scanner.hasNextLine();
	        }
	    };
	    return createStream(iterator);
	}

	public static DoubleStream doubleStream(Scanner scanner) {
	    Iterator<Double> iterator = new Iterator<Double>() {
	        public Double next() {
	            return scanner.nextDouble();
	        }
	        public boolean hasNext() {
	            return scanner.hasNextDouble();
	        }
	    };
	    return createStream(iterator).mapToDouble(Double::doubleValue);
	}

	public static void main(String[] args) {
		File file = new File("src/main/java/js8ri/ch08/ex05/Inquiry_about_room_rate.txt");
		try {
			Scanner scan = new Scanner(file);
			Stream<String> ws = wordStream(scan);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
