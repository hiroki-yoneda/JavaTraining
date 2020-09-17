package js8ri.ch01.ex11;

interface I {
    void f();
//    default void f() { System.out.println("I#f"); }
}

interface J {
    void f();
//    default void f() { System.out.println("J#f"); }
}

abstract class S {
    public abstract void f();
//    static void f() { System.out.println("S#f"); }
}

public class PriorityTest {
	static class A implements I, J {
		@Override
		public void f() { System.out.println("K#f"); }
	}

	static class B extends S implements I {
		@Override
		public void f() { System.out.println("L#f"); }

	}

	public static void main(String[] args) {
		new A().f();
        new B().f();
	}
}
