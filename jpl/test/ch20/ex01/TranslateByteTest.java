package jpl.ch20.ex01;

import org.junit.Test;

public class TranslateByteTest {
	@Test
	public void translateTest() {
		String[] args = {"resource.txt", "b", "B"};
		TranslateByte.main(args);
	}
}
