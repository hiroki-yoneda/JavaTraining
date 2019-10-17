package jpl.ch03.ex01;

public class VehicleOperation {

	public static void main(String[] args) {
		PassengerVehicle axcela = new PassengerVehicle();
		axcela.setSeatsNum(5);
		axcela.setPassengerNum(2);

		System.out.println("Seats:" + axcela.getSeatsNum() + "  Passengers:" + axcela.getPassengerNum());

		PassengerVehicle crown = new PassengerVehicle();
		crown.setSeatsNum(5);
		crown.setPassengerNum(4);

		System.out.println("Seats:" + crown.getSeatsNum() + "  Passengers:" + crown.getPassengerNum());
	}

}
