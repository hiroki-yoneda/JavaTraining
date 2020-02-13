package interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InterpretFrameWork {

	public static Object generateObject(String className)
			throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
			ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		return clazz.getDeclaredConstructor().newInstance(); // Class#newInstanceは非推奨 (https://blog.y-yuki.net/entry/2017/07/10/173000)
	}

	public static Constructor<?>[] getConstractor(String className) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
        Constructor<?>[] consArray = clazz.getDeclaredConstructors();
        return consArray;
	}

	public static Field[] getFields(String className) throws ClassNotFoundException {
		Field[] fields = Class.forName(className).getDeclaredFields(); // https://tyfkda.github.io/blog/2013/08/24/java-reflection.html
		for (Field field : fields)
			field.setAccessible(true); // 全てのフィールドにアクセスできるようにする。
		return fields;
	}

	// 指定されたオブジェクトのフィールド名の値を更新する
	public static <V> void updateField(String className, String fieldName, V value, Object instancedClass)
			throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
			ClassNotFoundException, NoSuchFieldException {
		Class<?> clazz = Class.forName(className);
		Field field = clazz.getDeclaredField(fieldName); // https://qiita.com/ohke/items/b096c5cb9d2932764f22
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
		return clazz.getDeclaredMethods();
	}

	public static void invokeMethod(String className, String methodName, Object instancedClass)
			throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
			ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		Method method = clazz.getMethod(methodName);
		method.invoke(instancedClass);
	}

	public static <T> T[] generateArray(Class<T> type, int size) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(type, size);
		return arr;
	}
}
