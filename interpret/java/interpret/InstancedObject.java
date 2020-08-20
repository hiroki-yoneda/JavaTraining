package interpret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstancedObject {

	static List<Object> objList;

	public static void setArray(Object[] objectArray) {
		// https://hacknote.jp/archives/23841/
		objList = new ArrayList<Object>(Arrays.asList(objectArray));
	}

	public static void add(int index, Object object) {
		objList.add(index, object);
	}

	public static Object get(int index) {
		return objList.get(index);
	}

	public static int getSize() {
		return objList.size();
	}
}
