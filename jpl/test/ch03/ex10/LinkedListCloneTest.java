package jpl.ch03.ex10;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class LinkedListCloneTest {

	@Test
	public void sucClone() {
		LinkedList list = new LinkedList();
        list.addFirst("abc");
        list.addFirst("def");
        LinkedList clonedList = list.clone();
        assertThat(list.toString(), is(clonedList.toString()));
	}

	// クローンしたリストを変更すると、オリジナルのリストも変更される
	@Test
	public void sucChangeEle() {
		LinkedList list = new LinkedList();
        list.addFirst("abc");
        list.addFirst("def");
        LinkedList clonedList = list.clone();
        clonedList.addFirst("ghi");
        assertThat(list.toString(), is(clonedList.toString()));
	}
}
