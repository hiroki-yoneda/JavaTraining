package jpl.ch02.ex14;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;;

public class ex14LinkedListTest {

	@Test
	public void testEx0LinkedList() {
        LinkedList list = new LinkedList();

        list.addFirst("abc");
        list.addFirst("def");
        assertThat(list.toString(), is("abc, def"));
	}

}
