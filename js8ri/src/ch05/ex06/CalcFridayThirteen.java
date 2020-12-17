package js8ri.ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class CalcFridayThirteen {

	public static void main(String[] args) {
		// 1901年1月1日 – 2000年12月31日
		YearMonth month = YearMonth.of(1901, Month.JANUARY);
		YearMonth lastMonth = YearMonth.of(2000, Month.DECEMBER);
		while (month.isBefore(lastMonth.plusMonths(1))) {
		    LocalDate day = month.atDay(13);
		    if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
		        System.out.println(day);
		    }
		    month = month.plusMonths(1);
		}
	}

}
