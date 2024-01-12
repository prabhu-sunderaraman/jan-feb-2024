import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        //Predicate is a FI that accepts data of ANY TYPE and returns a BOOLEAN

        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(21));
        System.out.println(isEven.test(1000));

        Predicate<String> notNull = value -> value != null;
        String str = null;
        System.out.println(notNull.test(str));

        //check if a number is even and divisible by 5
        int number = 12;
        if (number % 2 == 0 && number % 5 == 0) {
            System.out.println(number + " is even and divisible by 5");
        }
        Predicate<Integer> divBy5 = num -> num % 5 == 0;
        boolean result = isEven
                .and(divBy5)
                .test(number);

        //check if a number is even and divisible by 5 and greater than 100
        Predicate<Integer> gt100 = value -> value > 100;
        result = isEven
                .and(divBy5)
                .and(gt100)
                .test(number);
        boolean odd = isEven
                .negate()
                .test(12);


    }
}
