import java.util.Arrays;
import java.util.List;

public class StylesOfProgramming {
    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Chennai", "Houston", "Mexico City", "Mumbai", "Bengaluru");
        //Print all the cities starting with letter M

        //You are writing code by telling what to do and ALSO how to do
        //Imperative style of programming
        //Say you have 100K cities how do you run your code parallely and get the output?
        //You have to almost rewrite the code
        for (int i = 0; i < cities.size(); i++) {
            String city = cities.get(i);
            if (city.startsWith("M")) {
                System.out.println(city);
            }
        }
        //Declarative style of programming
        //You just say what to do and DON'T say how to do
        //Seamless
        //chaining of functions
        //promotes immutability
        cities
                .parallelStream()
                .filter(city -> city.startsWith("M"))
                .forEach(System.out::println);
    }
}
