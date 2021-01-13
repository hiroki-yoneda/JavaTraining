package js8ri.ch08.ex12;

public class TestTarget {
    @TestCase(param=4, expected=8)
    @TestCase(param=1, expected=2)
    public static int factorial(int n) {
        return n * 2;
    }
}
