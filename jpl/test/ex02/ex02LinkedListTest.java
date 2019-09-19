package practice02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import practice02.ex02.LinkedList;

public class ex02LinkedListTest {

	@Test
	public void testEx0LinkedList() {
        LinkedList list = new LinkedList();

        list.addFirst("abc");
        list.addFirst("def");
        assertThat(list.getLinkedList(), is("abc, def"));
	}

}
