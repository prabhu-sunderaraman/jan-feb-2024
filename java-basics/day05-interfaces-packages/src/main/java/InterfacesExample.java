import java.time.LocalDateTime;

public class InterfacesExample {
    public static void main(String[] args) {
        //Vehicle v = new Vehicle();
        Vehicle v = new Car();
        v.start();
        v.stop();
        Printer.doSomething();
        Printer hpPrinter = new PrinterImpl();
        hpPrinter.print("some data");
        hpPrinter.printDate();
        System.out.println(Printer.CARTRIDGE_TYPE);
    }
}

interface Printer {
    String CARTRIDGE_TYPE = "COLOR";

    void print(String data);

    default void printDate() {
        System.out.println(LocalDateTime.now());
    }

    static void doSomething() {

    }
}

class PrinterImpl implements Printer {
    public void print(String data) {
        System.out.println(data);
    }

    public void printDate() {
        Printer.super.printDate(); //calling the original method; weird syntax
    }
}

interface Vehicle {
    void start();

    void stop();
}

interface Machine {
    void assemble();
}

class Car implements Vehicle, Machine {
    public void start() {
    }

    public void stop() {
    }

    public void assemble() {
    }
}
