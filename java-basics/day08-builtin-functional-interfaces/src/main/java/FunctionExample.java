import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        //Function is a FI that takes data of ANY type and returns data of ANY type

        //increment a number
        Function<Integer, Integer> incrementor = num -> num + 1;
        int result = incrementor.apply(10);
        System.out.println(result);

        Function<String, Integer> length = value -> value.length();
        int len = length.apply("hello");
        System.out.println(len);

        //decrement a number, square it and double it
        int number = 10;
        Function<Integer, Integer> decrementor = num -> num - 1;
        Function<Integer, Integer> square = num -> num * num;
        Function<Integer, Integer> doubleIt = num -> num * 2;
        result = decrementor
                .andThen(square)
                .andThen(doubleIt)
                .apply(number);
        System.out.println(result);
        
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;
        result = adder.apply(10, 23);
    }
}
