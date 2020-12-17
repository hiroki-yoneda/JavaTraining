package js8ri.ch05.ex12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MeetingNotifier {

	public static void main(String[] args) {
		String meetingArea = "America/Los_Angeles";
		LocalDateTime meetingAreaDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0));
		ZoneId meetingAreaZoneId = ZoneId.of(meetingArea);
		ZonedDateTime timeOfMeetingArea = ZonedDateTime.of(meetingAreaDateTime, meetingAreaZoneId);
//		ZonedDateTime meetingTime = ZonedDateTime.of(timeOfMeetingArea, meetingAreaZoneId);
		//　わからなくなってきた。。。
	}

}
