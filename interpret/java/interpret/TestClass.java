package interpret;

import java.util.Arrays;

public class TestClass {

	public String publicField = "public field";
	private final String privateFinalField = "privateFinalField";
	private String privateString;
	public Integer integer;

	public TestClass(){
		System.out.println("引数なしTestClass");
	}

	public TestClass(String string, String string2){
		System.out.println("引数ありTestClass " + string+ " " + string2);
	}

	public TestClass(String string, Integer integer){
		this.privateString = string;
		this.integer = integer;
		System.out.println("引数ありTestClass" + string + " " + integer);
	}

	public void getValue() {
		System.out.println("String: " + privateString + " Integer: " + integer);
	}

	public void printPublicField() {
		System.out.println("invoked " + publicField);
	}

	public void printPrivateField() {
		System.out.println("invoked " + privateFinalField);
	}

	public void printIntegerField() {
		System.out.println(this.integer);
	}

	public void printIntegerArray(Integer[] intArray) {
		Arrays.stream(intArray).map(String::valueOf).forEach(s -> System.out.println(s));
	}

	public void printIntegerArray(String[] strArray) {
		Arrays.stream(strArray).forEach(s -> System.out.println(s));
	}

	private void printArgs(String string01, String string02) {
		System.out.println("引数ありメソッド " + string01+ " " + string02);
	}

	public void printArgsStrInt(String string01, Integer integer01) {
		System.out.println("引数ありメソッド " + string01+ " " + integer01);
	}
}
