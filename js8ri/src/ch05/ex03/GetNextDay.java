package js8ri.ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class GetNextDay {
	// https://qiita.com/opengl-8080/items/22c4405a38127ed86a31#predicatet

	public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = (LocalDate) w;
            do {
            	result = result.plusDays(1);
            } while (predicate.test(result));
            return result;
        });
    }

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate satisDay = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
		System.out.println(satisDay);
	}
}
