public class LambdasAsParameters {
    public static void main(String[] args) {
        //Look at the language design now

        //In OO languages all this while we were writing code where we have methods that accept data as arguments
        //we call the methods by passing data

        //BUT NOW

        //We have a different approach as well
        //We can have methods that accept behavior as arguments
        //we call the methods by passing the behavior

        Player tennisPlayer = () -> System.out.println("Playing Tennis");
        doSomething(tennisPlayer);

        doSomething(() -> System.out.println("Playing Cricket"));
        doSomething(() -> {
            System.out.println("Thinking of what to play");
            System.out.println("Not interested in playing anything");
        });
    }

    static void doSomething(Player player) {
        player.play();
    }
}

interface Player {
    void play();
}