public class Conditionals {
    public static void main(String[] args) {
        //if-else, ?:, switch-case
        String name = "Sampath";
        if (name.length() > 5) {
            System.out.println("Long name");
        } else {
            System.out.println("Short name");
        }
        //String comment =  if name.length() > 5 "Long Name" else "Short name";

        int num = 10;
        String message = num % 2 == 0 ? "Even" : "Odd";

        //switch-case statement OLD STYLE
        switch (num % 2) {
            case 0:
                message = "It's even number";
                break;
            case 1:
                message = "It's odd number";
                break;
            default:
                message = "I don't know what number this is";
                break;
        }

        //switch-case from java 17 has become an expression
        //MODERN STYLE
        message = switch (num % 2) {
            case 0 -> "Odd";
            case 1 -> "Even";
            default -> "WTH is this number";
        };





    }
}
