public class AbstractClasses {
    public static void main(String[] args) {
        //Animal animal = new Animal();
    }
}

abstract class Animal {
    public void eat() {
    }

    abstract void makeNoise();
}

class Dog extends Animal {
    public void makeNoise() {
        System.out.println("bow bow");
    }
}

class Cat extends Animal {
    public void makeNoise() {
        System.out.println("meow meow");
    }
}