package jpl.ch06.ex05;

/* enum定数宣言と比較し、可読性が失われるので推奨されない */
enum TrafficLights {
	RED{
		String getColor() {
			return "RED";
			}
		},
	YELLOW{
			String getColor() {
				return "YELLOW";
			}
		},
	GREEN{
			String getColor() {
				return "GREEN";
			}
		};

	abstract String getColor();
}
