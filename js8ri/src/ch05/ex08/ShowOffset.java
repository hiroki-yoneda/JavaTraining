package js8ri.ch05.ex08;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ShowOffset {
	public static void main(String[] arg) {
		ZoneId.getAvailableZoneIds().stream()
			.map(ZoneId::of)
			.forEach(zoneId->{
				ZonedDateTime now = ZonedDateTime.now(zoneId);
				System.out.println("Zone Id: " + zoneId + " offset: " + now.getOffset());
			});
	}
}
