public class PassByValueAndRef {
    public static void main(String[] args) {
        int number = 10;
        increment(number);
        System.out.println(number);

        Counter counter = new Counter(10);
        incrementCounter(counter);
        System.out.println(counter.getValue());
    }

    private static void incrementCounter(Counter counter) {
        counter.increment();
    }


    //In C# you have a keyword called ref
    private static void increment(int number) {
        number += 1;
    }

}
