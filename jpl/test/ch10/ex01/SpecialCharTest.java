package jpl.ch10.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialCharTest {
	@Test
	public void CheckSpecialChar() {
		ChangeToSpecialChar changeToSpecialChar = new ChangeToSpecialChar();
		assertThat(changeToSpecialChar.Change("\n"), is("\\n"));
		assertThat(changeToSpecialChar.Change("\t"), is("\\t"));
	}
}
