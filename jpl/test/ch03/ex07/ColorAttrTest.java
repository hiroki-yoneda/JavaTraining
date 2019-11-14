package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	@Test
	public void ColorAttrTest01() {
		ColorAttr red01 = new ColorAttr("red");
		red01.hashCode();
		ColorAttr red02 = new ColorAttr("red");
		red02.hashCode();
		assertFalse(red01.equals(red02));
	}
}
