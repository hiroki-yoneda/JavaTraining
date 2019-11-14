package jpl.ch02.ex11;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void LinkedList() {
        LinkedList list = new LinkedList();

        list.addFirst("abc");
        list.addFirst("def");
        assertThat(list.toString(), is("abc, def"));
	}

}
