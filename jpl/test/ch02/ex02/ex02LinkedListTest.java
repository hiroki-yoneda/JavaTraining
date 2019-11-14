package jpl.ch02.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class ex02LinkedListTest {

	@Test
	public void testEx0LinkedList() {
        LinkedList list = new LinkedList();

        list.addFirst("abc");
        list.addFirst("def");
        assertThat(list.getLinkedList(), is("abc, def"));
	}

}
