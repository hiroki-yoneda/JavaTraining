package interpret;

public class TestClass {

	public String publicField = "public field";
	private final String privateFinalField = "privateFinalField";

	public TestClass(){
		System.out.println("引数なしTestClass");
	}

	public void printPublicField() {
		System.out.println("invoked " + publicField);
	}

	public void printPrivateField() {
		System.out.println("invoked " + privateFinalField);
	}
}
