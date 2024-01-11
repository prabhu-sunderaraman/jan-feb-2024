public class SomeMoreOnLambdas {
    public static void main(String[] args) {
        //If your lambda expression is a single line "return" keyword is not required
        //the param names can be different, though not a common(or recommended) practice
        Worker worker1 = (t, h) -> "Working on %s for %s hours".formatted(t, h);
        System.out.println(worker1.work("Eating", 8));

        Worker worker2 = (String task, int hours) -> {
            System.out.println("Beginning to work on " + task);
            return "Working on %s for %s hours".formatted(task, hours);
        };
        System.out.println(worker2.work("poker", 5));

    }
}

@FunctionalInterface
interface Worker {
    String work(String task, int hours);
    //void something();
}
