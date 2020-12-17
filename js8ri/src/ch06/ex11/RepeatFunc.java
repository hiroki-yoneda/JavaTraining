package js8ri.ch06.ex11;

import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import com.google.common.base.Supplier;

public class RepeatFunc {

	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until){
		return CompletableFuture
				.supplyAsync(action)
				.thenComposeAsync(t -> until.test(t) ? CompletableFuture.completedFuture(t) : repeat(action, until));
	}

	public static void main(String[] args) {
		repeat(
				() -> {
					// console input
					String user = "sample";
					char[] pass = {'p', 'o', 'w', 'e', 'r'};
					return new PasswordAuthentication(user, pass);
				},
				passAuth -> {
					try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		            return Arrays.equals(passAuth.getPassword(), new char[] {'p', 'o', 'w', 'e', 'r'});
				}
		).thenAccept(System.out::println);

		ForkJoinPool.commonPool().awaitQuiescence(100, TimeUnit.SECONDS);
	}
}
