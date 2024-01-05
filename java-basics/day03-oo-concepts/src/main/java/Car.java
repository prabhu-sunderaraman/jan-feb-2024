//You are defining a new Reference Data type
public class Car {
    String model; //member variables or instance variables
    int yearOfMake;

    //instance methods
    void drive() { //method
        System.out.println("Driving a %syo %s".formatted(yearOfMake, model));
    }

    void applyBrakes() {
        System.out.println("Applying brakes on " + model);
    }
}
