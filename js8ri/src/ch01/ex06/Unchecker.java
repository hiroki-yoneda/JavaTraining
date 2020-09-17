package js8ri.ch01.ex06;

public class Unchecker {
	public static void main(final String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        return null;
    }

    interface RunnableEx {
        void run() throws Exception;
    }
}
