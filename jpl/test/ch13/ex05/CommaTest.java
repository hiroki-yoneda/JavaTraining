package jpl.ch13.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class CommaTest {
	@Test
	public void AppendCommaTest01() {
		String result = Comma.AppendComma("1234567");
		assertThat(result, is("1,234,567"));
	}

	@Test
	public void AppendCommaTest02() {
		String result = Comma.AppendComma("123456");
		assertThat(result, is("123,456"));
	}
}
