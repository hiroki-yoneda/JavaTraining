package js8ri.ch03.ex20;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapList {
	static <T, U> List<U> map(List<T> list, Function<T, U> f) {
		return list.stream().map(f::apply).collect(Collectors.toList());
	}
}
