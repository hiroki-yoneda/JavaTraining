package js8ri.ch05.ex01;

import java.time.LocalDate;
import java.time.Period;

public class CalcProgramerDay {

	public static void main(String[] args) {
		LocalDate programerDay = LocalDate.of(2020, 1, 1).plus(Period.ofDays(255));
		System.out.println(programerDay);
		LocalDate programerDayUsePlusDay = LocalDate.of(2020, 1, 1).plusDays(255);
		System.out.println(programerDayUsePlusDay);
	}
}
