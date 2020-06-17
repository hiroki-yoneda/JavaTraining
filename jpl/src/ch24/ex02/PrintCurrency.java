package jpl.ch24.ex02;


import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;


public class PrintCurrency {
	public static void main(String[] args) {
		Locale jp = new Locale("ja", "JP");
		Locale us = new Locale("en", "US");
		Locale de = new Locale("de", "DE");
		Locale ch = new Locale("zh", "CN");
		Locale fr = new Locale("fr", "Fr");
		Locale ko = new Locale("ko", "KR");

		final List<Locale> locales = Arrays.asList(jp, us, de, ch, fr, ko);

		locales.forEach(l -> {
			System.out.println(l);
			locales.forEach(r -> System.out.print(Currency.getInstance(r).getSymbol(l)));
			System.out.println();
		});
	}
}
