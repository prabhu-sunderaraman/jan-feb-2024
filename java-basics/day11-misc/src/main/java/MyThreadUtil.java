public class MyThreadUtil {
    public static void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String name() {
        return Thread.currentThread().getName();
    }
}
