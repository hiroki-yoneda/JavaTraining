package jpl.ch03.ex08;

/** clone をサポートする。基底クラスでClonableが実装されているので、ここではしない。 **/
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

	public PassengerVehicle clone() {
		PassengerVehicle clonedPassengerVehicle = (PassengerVehicle) super.clone();
		return clonedPassengerVehicle;
	}
}
