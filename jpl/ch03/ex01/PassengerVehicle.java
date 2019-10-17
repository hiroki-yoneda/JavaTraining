package jpl.ch03.ex01;

public class PassengerVehicle extends Vehicle {

	private int seatsNum;
	private int passengerNum;

	public PassengerVehicle() {
		super();
	}

	public final void setSeatsNum(int seatsNum) {
		this.seatsNum = seatsNum;
	}

	public final void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}

	public final int getSeatsNum() {
		return seatsNum;
	}

	public final int getPassengerNum() {
		return passengerNum;
	}
}
