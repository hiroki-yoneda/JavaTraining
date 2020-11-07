package js8ri.ch03.ex09;

import java.util.Arrays;
import java.util.Comparator;

public class CompareStrings {
	public static Comparator<Object> lexicographicComparator(String... fieldNames){
		// 問題がよく理解できなかった。
		return (obj1, obj2) -> {
			try {
				for (final String fieldName: fieldNames) {
					String val1 = obj1.getClass().getDeclaredField(fieldName).get(obj1).toString();
					String val2 = obj2.getClass().getDeclaredField(fieldName).get(obj2).toString();
					return val1.compareTo(val2) != 0 ? val1.compareTo(val2) : 0;
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return 0;
		};
	}

	static class Name {
		String firstName;
		String lastName;

		public Name(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return firstName + " " + lastName;
		}
	}

	public static void main(String[] args) {
		Name[] names = {new Name("aaaaa", "ddddd"), new Name("bbbbb", "ccccc")};
		Arrays.parallelSort(names, lexicographicComparator("firstName", "lastName"));
		System.out.println(Arrays.toString(names));
	}
}
