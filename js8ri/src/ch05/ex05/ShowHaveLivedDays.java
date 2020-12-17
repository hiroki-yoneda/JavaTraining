package js8ri.ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShowHaveLivedDays {

	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(1994, 2, 15);
		LocalDate now = LocalDate.now();
		System.out.println(ChronoUnit.DAYS.between(birthday,now));
	}

}
