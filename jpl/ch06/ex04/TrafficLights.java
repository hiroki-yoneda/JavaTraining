package jpl.ch06.ex04;

enum TrafficLights {
	RED("RED"),
	YELLOW("YELLOW"),
	GREEN("GREEN");

	String color;
	TrafficLights(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
