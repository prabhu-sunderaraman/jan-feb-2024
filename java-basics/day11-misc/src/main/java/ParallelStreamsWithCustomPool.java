import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamsWithCustomPool {
    public static void main(String[] args) {
        //create a list of 1000 elements
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            list.add(i);
        }

        int numberOfThreads = (int) (Runtime.getRuntime().availableProcessors() / (1 - 0.9));
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThreads);
        forkJoinPool.submit(() -> {
            list
                    .parallelStream()
                    .filter(e -> {
                        MyThreadUtil.sleep(1);
                        System.out.println("Filtering " + e + " on " + MyThreadUtil.name());
                        return e % 2 == 0;
                    })
                    .forEach(System.out::println);

        });
        MyThreadUtil.sleep(1000);
    }
}
