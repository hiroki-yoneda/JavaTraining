package jpl.ch20.ex02;

import java.io.IOException;

import org.junit.Test;

public class TranslateByteTest {
	@Test
	public void translateTest() throws IOException {
		String[] args = {"resource.txt", "b", "B"};
		TranslateByte.main(args);
	}
}
