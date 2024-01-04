public class StringManipulation {
    public static void main(String[] args) {
        //Use Strings when you don't have to change the values frequently in your application
        String name = "Ram";
        name += " is cool";
        name += " and a good coder";
        System.out.println(name);


        StringBuilder builder = new StringBuilder("Sam");
        builder.append(" is cool");
        builder.append(" and a good coder");
        String comment = builder.toString(); //the string pool comes into picture
        System.out.println(comment);
    }
}
