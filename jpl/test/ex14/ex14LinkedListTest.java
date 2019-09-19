package practice02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import practice02.ex11.LinkedList;

public class ex14LinkedListTest {

	@Test
	public void testEx0LinkedList() {
        LinkedList list = new LinkedList();

        list.addFirst("abc");
        list.addFirst("def");
        assertThat(list.toString(), is("abc, def"));
	}

}
