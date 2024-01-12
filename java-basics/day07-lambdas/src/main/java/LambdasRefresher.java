public class LambdasRefresher {
    public static void main(String[] args) {
        Animal dog = items -> System.out.println("Dog eating " + items);
        dog.eat("bones");
        System.out.println(dog.getClass().getName());

        Animal cat = (String items) -> System.out.println("Cat eating " + items);
        cat.eat("cereals");
        System.out.println(cat.getClass().getName());

        trainAnimalsToEat(dog);
        trainAnimalsToEat(cat);
        trainAnimalsToEat(items -> System.out.println("Lion eating " + items));
    }

    static void trainAnimalsToEat(Animal animal) {
        String item = "bread";
        animal.eat(item);
    }
}

@FunctionalInterface
interface Animal {
    void eat(String items);
    //void makeNoise();
}