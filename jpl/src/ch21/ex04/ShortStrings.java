package jpl.ch21.ex04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String> {
	private ListIterator<String> strings;
	private String nextShort;
	private String previousShort;
	private final int maxLen;

	public ShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
		previousShort = null;
	}

	@Override
	public boolean hasNext() {
		if (nextShort != null) { // すでに見つけている
			return true;
		}
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen) {
				return true;
			}
		}
		nextShort = null;//見つけられなかった
		return false;
	}

	@Override
	public String next() {
		if (nextShort == null && !hasNext()) {
			throw new NoSuchElementException();
		}
		String n = nextShort; //nextShortを記憶する
		nextShort = null; //nextShortを消費する
		return n; //nextShortを返す
	}

	@Override
	public boolean hasPrevious() {
		if (previousShort != null) { // すでに見つけている
			return true;
		}
		while (strings.hasPrevious()) {
			previousShort = strings.previous();
			if (previousShort.length() <= maxLen) {
				return true;
			}
		}
		previousShort = null;
		return false;
	}

	@Override
	public String previous() {
		if (previousShort == null && !hasPrevious()) {
			throw new NoSuchElementException();
		}
		String n = previousShort; //previousShortを記憶する
		previousShort = null; //previousShortを消費する
		return n; //previousShortを返す
	}

	@Override
	public int nextIndex() {
		return strings.nextIndex();
	}

	@Override
	public int previousIndex() {
		// TODO 自動生成されたメソッド・スタブ
		return strings.previousIndex();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(String e) {
		strings.set(e);
	}

	@Override
	public void add(String e) {
		strings.set(e);
	}

}
