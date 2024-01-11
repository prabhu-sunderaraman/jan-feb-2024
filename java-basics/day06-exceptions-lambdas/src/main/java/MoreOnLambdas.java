public class MoreOnLambdas {
    public static void main(String[] args) {
        //Functional interface
        Greetings greetingsInHindi = name -> System.out.println("Namaste " + name);
        greetingsInHindi.greet("Sam");

        Greetings greetingsInSpanish = (String name) -> System.out.println("Adios " + name);
        greetingsInSpanish.greet("Marcos");

        Greetings greetingsInEnglish = name -> {
            System.out.println("Hello " + name);
            System.out.println("Hi " + name);
            System.out.println("Welcome " + name);
        };
        greetingsInEnglish.greet("Joe");
    }
}

@FunctionalInterface
interface Greetings {
    void greet(String name);
    //void hi(String name);

    default void hello() {
        System.out.println("Hello");
    }

    default void bye() {
        System.out.println("Bye");
    }
}