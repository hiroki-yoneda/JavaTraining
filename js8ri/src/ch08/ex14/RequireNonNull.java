package js8ri.ch08.ex14;

import java.util.Objects;

public class RequireNonNull {

	public static void main(String[] args) {
		// ??? 役立つエラーメッセージとは？
		Objects.requireNonNull(null, () -> "Arg is null.");
	}
}
