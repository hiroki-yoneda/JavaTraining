package dc.dc1_2;

public enum FontSize {
	FONT_SIZE_12("12"),
	FONT_SIZE_24("24"),
	FONT_SIZE_36("36"),
	FONT_SIZE_48("48"),
	FONT_SIZE_60("60"),
	FONT_SIZE_72("72");

	private final String name;
	FontSize(String name){ this.name = name; }
	public String toString() { return name; }
}
