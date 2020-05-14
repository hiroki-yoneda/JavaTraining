package dc.dc2_2;

import static dc.dc2_2.ConstantClass.*;

import java.awt.Color;
import java.awt.Font;

public class Property {
	private String font = "American Typewriter";
	private int fontSize = 30;
	private Color clockColor = Color.white;
	private Color backColor = Color.black;
	private int fontStyle = Font.PLAIN;

	public void setFont(String font) {
		this.font = font;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setClockColor(String clockColor) {
		this.clockColor = changeStringToColor(clockColor);
	}

	public void setBackColor(String backColor) {
		this.backColor = changeStringToColor(backColor);
	}

	public Font getFontSetting() {
		return new Font(font, fontStyle, fontSize);
	}

	public Color getClockColor() {
		return clockColor;
	}

	public Color getBackColor() {
		return backColor;
	}

	public int getFontSize() {
		return fontSize;
	}

	public Color changeStringToColor(String colorString) {
		for (int i = 0; i < STRING_COLOR.length; i++) {
			if (colorString == STRING_COLOR[i]) {
				return COLER_COLER[i];
			}
		}
		return Color.black;
	}

}
