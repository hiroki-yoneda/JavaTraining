package jpl.ch21.ex04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testShortStrings {
	@Test
	public void NextShortStrings() {
		List<String> list = new ArrayList<>();
		list.add("asgrh");
		list.add("djh");
		list.add("fghh");
		list.add("ahggg");
		ShortStrings shortStrings = new ShortStrings(list.listIterator(), 4);
		shortStrings.hasNext();
		assertThat(shortStrings.next(), is("djh"));
	}

	@Test
	public void PreviousShortStrings() {
		List<String> list = new ArrayList<>();
		list.add("asgrh");
		list.add("djh");
		list.add("fghh");
		list.add("ahggg");
		ShortStrings shortStrings = new ShortStrings(list.listIterator(), 4);
		while(shortStrings.hasNext()) {
			shortStrings.next();
		}
		shortStrings.hasPrevious();
		assertThat(shortStrings.previous(), is("fghh"));
	}
}
