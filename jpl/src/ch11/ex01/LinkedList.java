package jpl.ch11.ex01;

public class LinkedList<E> {

	/* ToDo リストの取得 */
	E obj;
	LinkedList<E> next;

	public void setObj(E obj) {
		this.obj = obj;
	}

	public LinkedList<E> getNext() {
		return next;
	}

	public void setNext(LinkedList<E> next) {
		this.next = next;
	}
}
