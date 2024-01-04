public class StringExample {
    public static void main(String[] args) {
        //Strings are reference types though they look like primitive types syntactically
        String name = "Sam";
        String city = "Mexico city";
        System.out.println(name);
        System.out.println(city);

        String country = "India";
        country = "US"; //Strings are immutable
        country = "Canada";

        String message = "";
        for (int i = 0; i < 10; i++) {
            message += i;
        }
        //At the end of this loop, there would have been 10 objects created
        //Use Strings as constants and avoid too frequent manipulations

        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < 10; i++) {
            builder.append(i);
        }
        System.out.println(builder.toString()); //0123456789
    }
}
