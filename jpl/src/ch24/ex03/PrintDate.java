package jpl.ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PrintDate {
	private static final List<Integer> formats = Arrays.asList(DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL);
	public static void printDate(final String strDate) {
		final DateFormat format = DateFormat.getDateInstance();
		try {
			final Date date = format.parse(strDate);
			formats.forEach(f -> System.out.println(DateFormat.getDateInstance(f).format(date)));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		PrintDate.printDate("2020/05/31 18:12:12");
	}
}
