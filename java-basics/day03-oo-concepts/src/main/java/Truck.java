public class Truck {
    private String model;
    private double price;

    //In C# the equivalent of getter/setter methods is Properties
    //Props begin with UpperCase

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public Truck(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public void drive(int speed) {
        System.out.println("Driving %s at a speed of %smph".formatted(model, speed));
    }
}
