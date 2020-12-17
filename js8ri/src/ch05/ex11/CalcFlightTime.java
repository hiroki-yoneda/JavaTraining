package js8ri.ch05.ex11;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CalcFlightTime {

	public static void main(String[] args) {
		String departurePlace = "CET";
		String arrivalPlace = "America/Los_Angeles";

		LocalDateTime depatrureLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 5));
		ZoneId departureZoneId = ZoneId.of(departurePlace);
		LocalDateTime arrivalLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 40));
		ZoneId arrivalZoneId = ZoneId.of(arrivalPlace);

		ZonedDateTime departureTime = ZonedDateTime.of(depatrureLocalDateTime, departureZoneId);
		ZonedDateTime arrivalTime = ZonedDateTime.of(arrivalLocalDateTime, arrivalZoneId);

		System.out.println(Duration.between(departureTime, arrivalTime));
	}
}
