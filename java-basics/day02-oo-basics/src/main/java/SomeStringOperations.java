public class SomeStringOperations {
    public static void main(String[] args) {
        String title = "Object Oriented Programming";
        System.out.println(title.toUpperCase());
        System.out.println(title.toLowerCase());
        System.out.println(title.charAt(0));
        System.out.println(title.substring(0, 6));
        System.out.println(title.split(" "));
        System.out.println(title.contains("Revathi"));
        String paragraph = """
                Hello!
                    Welcome to the training!
                            It's too boring;
                            I am feeling sleepy already!
                """;
        System.out.println(paragraph);
    }
}
