package jpl.ch13.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class SpliterTest {
	@Test
	public void SplitStrTest01() {
		String result = Spliter.SplitStr("1234567", 2, "/");
		assertThat(result, is("1/23/45/67"));
	}

	@Test
	public void SplitStrTest02() {
		String result = Spliter.SplitStr("123456", 3, "-");
		assertThat(result, is("123-456"));
	}
}
