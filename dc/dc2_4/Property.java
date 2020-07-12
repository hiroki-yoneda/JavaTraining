package dc.dc2_4;

import static dc.dc2_4.ConstantClass.*;

import java.awt.Color;
import java.awt.Font;

import com.google.common.base.Objects;

public class Property {
	private String font;
	private int fontSize;
	private Color clockColor;
	private String clockStringColor;
	private Color backColor;
	private String backStringColor;
	private int fontStyle;

	public Property() {
		font = "American Typewriter";
		fontSize = 30;
		clockColor = Color.white;
		clockStringColor = "White";
		backColor = Color.black;
		backStringColor = "Black";
		fontStyle = Font.PLAIN;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setClockColor(String clockColor) {
		this.clockStringColor = clockColor;
		this.clockColor = changeStringToColor(clockColor);
	}

	public void setBackColor(String backColor) {
		this.backStringColor = backColor;
		this.backColor = changeStringToColor(backColor);
	}

	public String getStringFont() {
		return this.font;
	}

	public String getClockStringColor() {
		return this.clockStringColor;
	}

	public String getClockStringBackColor() {
		return this.backStringColor;
	}

	public Font getFontSetting() {
		return new Font(font, fontStyle, fontSize);
	}

	public Color getClockColor() {
		System.out.println(clockStringColor);
		return this.clockColor;
	}

	public Color getBackColor() {
		System.out.println(backStringColor);
		return this.backColor;
	}

	public int getFontSize() {
		return this.fontSize;
	}

	public Color changeStringToColor(String colorString) {
		for (int i = 0; i < STRING_COLOR.length; i++) {
			if (Objects.equal(colorString, STRING_COLOR[i])) {
				return COLER_COLER[i];
			}
		}
		System.out.println("return black");
		return Color.black;
	}

}
