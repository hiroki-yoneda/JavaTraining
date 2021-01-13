package js8ri.ch08.ex12;

import java.lang.reflect.Method;

public class TestExec {

	public static void main(String[] args) {
		String target = "js8ri.ch08.ex12.TestTarget";
		try {
			Class<?> clazz = Class.forName(target);
			for (Method method : clazz.getMethods()) {
		        TestCases testCases = method.getAnnotation(TestCases.class);
		        if (testCases == null)
		            continue;
		        for (TestCase testCase : testCases.value()) {
		            try {
		                int ret = (Integer)method.invoke(null, testCase.param());
		                if (ret == testCase.expected()) {
		                    System.out.println("Success");
		                } else {
		                    System.out.println("Failure, result is " + ret);
		                }
		            } catch (Exception e) {
		            	e.printStackTrace();
		            }
		        }
		    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
