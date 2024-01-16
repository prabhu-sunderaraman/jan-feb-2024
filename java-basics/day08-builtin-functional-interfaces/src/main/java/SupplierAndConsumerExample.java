import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndConsumerExample {
    public static void main(String[] args) {
        //Supplier is a FI that does not accept anything and just returns data of ANY type
        Supplier<Integer> randomNoSupplier = () -> (int) (Math.random() * 1000);
        System.out.println(randomNoSupplier.get());

        Supplier<String> now = () -> LocalDateTime.now().toString();
        System.out.println(now.get());

        //Consumer is a FI that accepts data of ANY type and does not return anything
        //Used in foreach methods
        Consumer<String> printer = value -> System.out.println(value);
        printer.accept("hello world");

        Consumer<String> logger = value -> {
            System.out.println("Logging...");
            System.out.println(value);
        };
        logger.accept("Entry created in DB");
    }
}
