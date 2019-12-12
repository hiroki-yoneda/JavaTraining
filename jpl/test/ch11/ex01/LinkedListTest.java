package jpl.ch11.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	/* error */
	@Test
	public void addListTest() {
		LinkedList<String> list01 = new LinkedList<String>();
		LinkedList<String> list02 = new LinkedList<String>();
		list01.setObj("a");
		list02.setObj("b");
		list01.setNext(list02);
		System.out.println(list01);
		assertThat(list01.obj, is(""));
	}
}
