import java.util.*;
import java.util.function.Consumer;

public class ProcessingCollections {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "Golang", "JavaScript", "C#");
        //If you want to iterate or loop through a collection a for-loop or while-loop is OLD STYLE
        languages.forEach(item -> System.out.println(item));
        languages.forEach(System.out::println);
        Consumer<String> logger = value -> System.out.println("Logging... " + value);
        languages.forEach(logger);

        Set<String> cities = Set.of("Pune", "Mexico City", "Telaviv", "Mumbai");
        cities.forEach(System.out::println);

        Map<Integer, String> romanNumbers = new HashMap<>();
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
