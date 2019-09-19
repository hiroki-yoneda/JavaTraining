package practice02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import practice02.ex16.LinkedList;;

public class ex16LinkedListTest {

	@Test
	public void testEx0LinkedList() {
		LinkedList list = new LinkedList();

        list.addFirst("abc");
        list.addFirst("def");
        list.addFirst("ghi");
        assertThat(list.countNum(), is(3));
	}

}
