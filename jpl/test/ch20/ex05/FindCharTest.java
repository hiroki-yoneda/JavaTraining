package jpl.ch20.ex05;

import java.io.IOException;

import org.junit.Test;

public class FindCharTest {
	@Test
	public void translateTest() throws IOException {
		String[] args = {"resource.txt", "b"};
		FindChar.main(args);
	}
}
