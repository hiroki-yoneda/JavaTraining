package js8ri.ch05.ex10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CalcArriveTime {

	public static void main(String[] args) {
		String departurePlace = "America/Los_Angeles";
		String arrivalPlace = "CET";
		Duration flightTime = Duration.ofMinutes(60*10 + 50);

		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 5));
		ZoneId departureZoneId = ZoneId.of(departurePlace);
		ZoneId arrivalZoneId = ZoneId.of(arrivalPlace);

		ZonedDateTime time = ZonedDateTime.of(localDateTime, departureZoneId).plus(flightTime).withZoneSameInstant(arrivalZoneId);
		System.out.println(time);
	}
}
