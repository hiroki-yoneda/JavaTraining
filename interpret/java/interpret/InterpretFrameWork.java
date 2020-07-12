package interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InterpretFrameWork {

	public static Object generateObject(Constructor<?> cons, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object instancedObject;
		if (args.length == 0) {
			instancedObject = cons.newInstance();
		} else {
			instancedObject = cons.newInstance(args);
		}
		return instancedObject; // Class#newInstanceは非推奨 (https://blog.y-yuki.net/entry/2017/07/10/173000)
	}

	public static Constructor<?>[] getConstractor(String className) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		Constructor<?>[] consArray = clazz.getDeclaredConstructors();
		return consArray;
	}

	public static Class<?>[] getConstructorParams(Constructor<?> constructor) {
		return constructor.getParameterTypes();
	}

	public static Field[] getFields(String className) throws ClassNotFoundException {
		Field[] fields = Class.forName(className).getDeclaredFields(); // https://tyfkda.github.io/blog/2013/08/24/java-reflection.html
		for (Field field : fields)
			field.setAccessible(true); // 全てのフィールドにアクセスできるようにする。
		return fields;
	}

	public static Object getFieldValue(Field field, Object instancedClass) throws IllegalArgumentException, IllegalAccessException {
		return field.get(instancedClass);
	}

	// 指定されたオブジェクトのフィールド名の値を更新する
	public static void updateField(Field field, Object instancedClass, Object value) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		field.setAccessible(true);
		updateAccessibleField(field);
		field.set(instancedClass, value);
	}

	// private final field value を修正可能にする
	// https://stackoverflow.com/questions/3301635/change-private-static-final-field-using-java-reflection
	public static void updateAccessibleField(Field field)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL); // WARNING https://qiita.com/rubytomato@github/items/3d9f657196c1e941699a#illegal-reflective-access
	}

	public static Method[] getMethods(String className) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
//		return clazz.getDeclaredMethods(); // selfClass all methods
		return clazz.getMethods(); // selfClass and superClass public methods
	}

	public static void invokeMethod(Method method, Object instancedClass, Object... args)
			throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
			ClassNotFoundException {
		method.setAccessible(true);
		if (args.length == 0) {
			if (method.getReturnType() != void.class) {
				InterpretScreen.printResult(method.invoke(instancedClass).toString());
			}
			method.invoke(instancedClass);
		}
		if (args.length > 0) {
			if (method.getReturnType() != void.class) {
				InterpretScreen.printResult(method.invoke(instancedClass, args).toString());
			}
			method.invoke(instancedClass, args);
		}
	}

	public static <T> T[] generateArray(Class<T> type, int size) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(type, size);
		return arr;
	}
}
