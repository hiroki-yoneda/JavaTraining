package jpl.ch13.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class counterTest {
	@Test
	public void countStr() {
		String str = "aabbccdd";
		int result = counter.countSpecificStr(str, "aa");
		assertThat(result, is(1));
	}
}
