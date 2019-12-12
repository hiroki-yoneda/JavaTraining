package jpl.ch13.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class counterTest {
	@Test
	public void countChar() {
		String str = "aabbccdd";
		int result = counter.countSpecificChar(str, 'a');
		assertThat(result, is(2));
	}
}
