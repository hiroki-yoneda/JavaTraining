package jpl.ch13.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DelimitedStringTest {
	@Test
	public void delimitedStringTest01() {
		List<String> resultList = DelimitedString.delimitedString("abcdefg", 'b', 'd');
		List<String> exceptList = Arrays.asList("ab", "cd", "efg");
		assertThat(resultList, is(exceptList));
	}

	@Test
	public void delimitedStringTest02() {
		List<String> resultList = DelimitedString.delimitedString("abcdefg", 'a', 'd');
		List<String> exceptList = Arrays.asList("a", "bcd", "efg");
		assertThat(resultList, is(exceptList));
	}

	@Test
	public void delimitedStringTest() {
		List<String> resultList = DelimitedString.delimitedString("abcdefg", 'd', 'b');
		assertThat(resultList, is(nullValue()));
	}
}
