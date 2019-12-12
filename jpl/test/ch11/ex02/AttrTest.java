package jpl.ch11.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AttrTest {
	@Test
	public void stringValueTest() {
		Attr<String> stringAttr = new Attr<String>("Alex", "man");
		assertThat(stringAttr.getValue(), is("man"));
	}

	@Test
	public void intValueTest() {
		Attr<Integer> intAttr = new Attr<Integer>("Alex", 26);
		assertThat(intAttr.getValue(), is(26));
	}
}
