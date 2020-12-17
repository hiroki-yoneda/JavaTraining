package js8ri.ch05.ex09;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ShowOffset {
	public static void main(String[] arg) {
		ZoneId.getAvailableZoneIds().stream()
		.map(ZoneId::of)
		.map(ZonedDateTime::now)
		.filter(now -> Math.abs(now.getOffset().getTotalSeconds()) < 3600)
		.forEach(System.out::println);
	}
}
