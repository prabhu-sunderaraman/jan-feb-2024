import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "Golang", "JavaScript", "C#");
        //Print all the languages beginning with Letter J
        //Print all the languages beginning with Letter J and with length more than 5
        //Print all the languages beginning with letter J in UpperCase

        //java 1.8 introduces Stream API
        Stream<String> langStream = languages.stream();
        langStream
                .filter(lang -> lang.startsWith("J"))
                .forEach(System.out::println);

        Stream<String> langStream2 = languages.stream();
        langStream2
                .filter(lang -> lang.startsWith("J"))
                .filter(lang -> lang.length() > 5)
                .forEach(System.out::println);

        //ERROR; Streams cannot be reused. Once they are operated upon, you have to create a new stream
        languages
                .stream() //always create a new stream and operate upon as they cannot be reused
                .filter(lang -> lang.startsWith("J"))
                .filter(lang -> lang.length() > 5)
                .forEach(System.out::println);

        //Streams process data sequentially by default
        //Streams are used for READING PURPOSES ONLY; The underlying collection cannot be modified
        languages
                .stream()
                .filter(lang -> lang.startsWith("J"))
                .map(lang -> lang.toUpperCase()) //map is a method that takes in a Function as argument
                .forEach(System.out::println);

        List<String> newList = languages
                .stream()
                .filter(lang -> lang.startsWith("J"))
                .map(lang -> lang.toUpperCase())
                .collect(Collectors.toList());

        newList.forEach(System.out::println);

        System.out.println("************************************");
        //Streams are lazily evaluated
        languages
                .stream()
                .filter(lang -> lang.endsWith("t")) //NOT EVALUATED AT ALL
                //.forEach(System.out::println); //terminal operation
                .collect(Collectors.toList()); //terminal operation

        //LAZILY EVALUATED
        Stream<String> processingStream = languages
                .stream()
                .filter(e -> e.startsWith("J"))
                .map(e -> e.toUpperCase());

        processingStream.forEach(System.out::println);

    }
}
