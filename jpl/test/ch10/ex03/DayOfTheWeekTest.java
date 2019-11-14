package jpl.ch10.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class DayOfTheWeekTest {
	@Test
	public void DayOfTheWeek() {
		DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
		assertThat(dayOfTheWeek.isWorkDay(Week.SUNDAY), is(false));
		assertThat(dayOfTheWeek.isWorkDay(Week.MONDAY), is(true));
	}
}
