import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {
    public static void main(String[] args) {
        //create a list of 1000 elements
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            list.add(i);
        }

        list
                .parallelStream()//Internally a fork join pool is used with a default size of (number of processors - 1)
                .filter(e -> {
                    MyThreadUtil.sleep(1);
                    System.out.println("Filtering " + e + " on " + MyThreadUtil.name());
                    return e % 2 == 0;
                })
                .forEach(System.out::println);
    }
}
