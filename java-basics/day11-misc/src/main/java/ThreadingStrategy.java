import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingStrategy {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores: " + cores);
        //CPU intensive tasks or IO intensive tasks
        //CPU intensive tasks: number of threads <= number of cores
        //IO intensive tasks: number of threads > number of cores

        //number of threads = number of cores / (1 - blocking factor)
        //blocking factor is between 0 and 1

        //For an IO intensive task, blocking factor is 0.9
        int numberOfThreads = (int) (cores / (1 - 0.9));
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        System.out.println("Number of threads for IO intensive task: " + numberOfThreads);

        //For a CPU intensive task, blocking factor is 0.1
        numberOfThreads = (int) (cores / (1 - 0.05));
        System.out.println("Number of threads for CPU intensive task: " + numberOfThreads);


    }
}
