public class DesignUsingLambdas {
    public static void main(String[] args) {
        checkEven(12);
        checkOdd(121);

        check(num -> System.out.println("Is %s even ?: %s".formatted(num, num % 2 == 0)));
        check(num -> System.out.println("Is %s odd ?: %s".formatted(num, num % 2 != 0)));
        check(num -> System.out.println("Is %s prime ?: %s".formatted(num, "Need to check if it's prime")));
        check(num -> System.out.println("Is %s composite ?: %s".formatted(num, "Need to check if it's composite")));
    }

    //Modern design where you have data and you pass the behavior(or functionality)
    static void check(NumberCheck numberCheck) {
        //I will go fetch the number from say a remote service
        int number = 12;
        //You tell me what to check on this number
        numberCheck.check(number);
    }


    //Traditional design where you have a lot of methods and you pass data
    static void checkEven(int number) {
        System.out.println("Is %s even ?: %s".formatted(number, number % 2 == 0));
    }

    static void checkOdd(int number) {
        System.out.println("Is %s odd ?: %s".formatted(number, number % 2 != 0));
    }

    static void checkPrime(int number) {

    }

    static void checkComposite(int number) {

    }
}

interface NumberCheck {
    void check(int number);
}
