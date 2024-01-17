import java.util.Arrays;
import java.util.List;

public class InternalsOfStream {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Groovy", "Scala", "Java", "C#", "Golang", "JavaScript", "Python");
        //Streams take every item in the collection and passes it through all the stages till the terminal operation
        //Very different in languages like JavaScript where the entire collection is passed through the stages
        languages
                .stream()
                .filter(e -> {
                    System.out.println("****inside filter " + e);
                    return e.startsWith("J");
                })
                .map(e -> {
                    System.out.println("====inside map " + e);
                    return e.toUpperCase();
                })
                .findAny()
                .get();
//                .forEach(e -> {
//                    System.out.println("----inside forEach " + e);
//                    System.out.println(e);
//                });
    }
}
