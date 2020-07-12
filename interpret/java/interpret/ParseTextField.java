package interpret;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParseTextField {
	public static Object parseText(String text, Class<?> clazz) {
		if (clazz.isArray()) {
			if (clazz.getTypeName().contains("Integer") || clazz.getTypeName().contains("int") || clazz.getTypeName().contains("Number")) {
				return createIntegerArray(text);
			}
			if (clazz.getTypeName().contains("Double") || clazz.getTypeName().contains("double")) {
				return createDoubleArray(text);
			}
			if (clazz.getTypeName().contains("String")) {
				return (String[]) text.split(",");
			}
			if (clazz.getTypeName().contains("Object")) {
				return (Object[]) text.split(",");
			}
		} else if (clazz.getTypeName().contains("Collection")) { // todo
			return Arrays.stream(text.split(",")).collect(Collectors.toList());

		} else if (clazz.getTypeName().contains("Integer") || clazz.getTypeName().contains("int") || clazz.getTypeName().contains("Number")) {
			return Integer.parseInt(text);
		} else if (clazz.getTypeName().contains("Double") || clazz.getTypeName().contains("double")) {
			return Double.parseDouble(text);
		} else if (clazz.getTypeName().contains("boolean")) {
			if (Objects.equals(text, "true")) {
				return true;
			}
			return false;
		} else if (clazz.getTypeName().contains("Color")) {
			Color color = null;
			try {
				Field field = Class.forName("java.awt.Color").getField(text);
				color = (Color) field.get(null);
			} catch (Exception e) {
				System.out.println("error");
				color = null;
			}
			return color;
		}
		// TODO every cast

		return text;
	}

	public static Object[] createIntegerArray(String text) {
		return Arrays.stream(text.split(",")).map(Integer::valueOf).toArray(Integer[]::new);
	}

	public static Object[] createDoubleArray(String text) {
		return Arrays.stream(text.split(",")).map(Integer::valueOf).toArray(Double[]::new);
	}
}
