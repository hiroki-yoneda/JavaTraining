package js8ri.ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ShowCalender {

	public static void main(String[] args) {
		LocalDate firstDay = LocalDate.of(2020, 11, 1);
		final int nesessarySpace = firstDay.getDayOfWeek().getValue();
		for (int i = 1; i < nesessarySpace; i++) {
			System.out.print("   ");
		}
		int lengthOfMonth = firstDay.lengthOfMonth();
		for (int i = 0; i < lengthOfMonth; i++) {
			LocalDate d = firstDay.plusDays(i);
			System.out.print(String.format("%2d ", d.getDayOfMonth()));
			if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
				System.out.println();
			} else {
				System.out.print("");
			}
		}
	}
}
