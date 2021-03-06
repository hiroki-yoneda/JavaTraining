package application;

import java.awt.GraphicsEnvironment;

public class Property {
	public final static String FONTS[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public static final int FONT_SIZE[] = {30, 60, 90};
	public static final String STRING_COLOR[] = { "Black", "White", "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "Orange" };

	private String font;
	private int font_size;
	private String backGroundColor;
	private String fontColor;

	public Property() {
		this.font = "Apple Chancery";
		this.font_size = 30;
		this.backGroundColor = "White";
		this.fontColor = "Black";
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getFont() {
		return this.font;
	}

	public void setFontSize(int font_size) {
		this.font_size = font_size;
	}

	public int getFontSize() {
		return font_size;
	}

	public void setBackgroundColor(String color) {
		this.backGroundColor = color;
	}

	public String getBackgroundColor() {
		return this.backGroundColor;
	}

	public void setFontColor(String color) {
		this.fontColor = color;
	}

	public String getFontColor() {
		return this.fontColor;
	}
}
