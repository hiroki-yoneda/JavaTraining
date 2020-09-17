package js8ri.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class CaptureExtFor {

	private static void useExtFor(String[] names) {
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        runners.stream().forEach(Runnable::run);
	}

	private static void useFor(String[] names) {
		List<Runnable> runners = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			// Local variable i defined in an enclosing scope must be final or effectively final
            // runners.add(() -> System.out.println(names[i]));
        }
        runners.stream().forEach(Runnable::run);
	}

	public static void main(final String... args) {
        String[] names = {"Peter", "Paul", "Mary"};
        useExtFor(names);
        useFor(names);
    }
}
