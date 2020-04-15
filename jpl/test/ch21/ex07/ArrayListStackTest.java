package jpl.ch21.ex07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class ArrayListStackTest {
	@Test
	public void PopTest() {
		final ArrayListStack<Integer> stack = new ArrayListStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertThat(stack.pop(), is(3));
	}

	@Test
	public void SearchSuccessTest() {
		final ArrayListStack<Integer> stack = new ArrayListStack<>();
		stack.push(1);
		stack.push(2);
		assertThat(stack.search(2), is(1));
	}

	@Test
	public void SearchFailTest() {
		final ArrayListStack<Integer> stack = new ArrayListStack<>();
		stack.push(1);
		stack.push(2);
		assertThat(stack.search(4), is(-1));
	}

	@Test(expected = EmptyStackException.class)
	public void ExeptionTest() {
		final ArrayListStack<Integer> stack = new ArrayListStack<>();
		stack.pop();
	}
}

