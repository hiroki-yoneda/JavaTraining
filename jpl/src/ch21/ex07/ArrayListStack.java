package jpl.ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> {
	ArrayList<E> list = new ArrayList<>();

	public void push(final E e) {
		this.list.add(e);
	}

	public E peek() {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.get(list.size() - 1);
	}

	public E pop() {
		E e = peek();
		list.remove(list.size() - 1);
		return e;
	}

	public int search(E e) {
		int lastIndex = list.lastIndexOf(e);
		if (lastIndex >= 0) {
			return list.size() - lastIndex;
		}
		return -1;
	}
}
