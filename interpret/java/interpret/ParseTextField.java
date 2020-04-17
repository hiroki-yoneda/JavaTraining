package interpret;

import java.util.Arrays;
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
