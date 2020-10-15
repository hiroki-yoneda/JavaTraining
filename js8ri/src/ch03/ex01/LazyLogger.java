package js8ri.ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LazyLogger {
	static Logger logger;

	public static void logIf(Level level, BooleanSupplier condition, Supplier<String> msgSupplier) {
		if (condition.getAsBoolean()) {
            logger.log(level, msgSupplier);
        }
	}

    public static void main(String[] args) {
    	logger = Logger.getLogger("SampleLogging");
    	logIf(Level.INFO, () -> true, () -> "This is log");
    }
}
