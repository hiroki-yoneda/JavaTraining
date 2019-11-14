package jpl.ch10.ex03;

public class DayOfTheWeek {
	public boolean isWorkDay(Week week){
		switch(week){
		case SUNDAY: case SATURDAY:
				return false;
		default: return true;
		}
	}
}
