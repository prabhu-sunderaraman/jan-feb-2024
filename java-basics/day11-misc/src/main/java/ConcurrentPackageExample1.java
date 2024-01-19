import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentPackageExample1 {
    public static void main(String[] args) {
        //No more creating threads explicitly
        //If you want to work with threads use ExecutorService
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ForkJoinPool executorService = ForkJoinPool.commonPool();

        executorService.submit(() -> {
            while (true) {
                System.out.println("Walking on " + MyThreadUtil.name() + " thread");
                MyThreadUtil.sleep(1);
            }
        });

        executorService.submit(() -> {
            int count = 0;
            while (count < 5) {
                System.out.println("Talking on " + MyThreadUtil.name() + " thread");
                MyThreadUtil.sleep(2);
                count++;
            }
        });

        executorService.submit(() -> {
            while (true) {
                System.out.println("Browsing on " + MyThreadUtil.name() + " thread");
                MyThreadUtil.sleep(2);
            }
        });
        MyThreadUtil.sleep(100);

    }
}
