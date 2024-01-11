public class BasicsOfLambdas {
    public static void main(String[] args) {
        Printer oldPrinter = new PrinterImpl();
        oldPrinter.print("Hello there!");

        //Anonymous inner class
        Printer decentPrinter = new Printer() {
            public void print(String data) {
                System.out.println(data);
            }
        };
        decentPrinter.print("Hi!");

        Printer decentPrinter2 = new Printer() {
            public void print(String data) {
                System.out.println(data);
            }
        };
        decentPrinter2.print("Hi!");

        //-> is called lambda operator
        //Lambda expression in Java is a shortcut for defining a class that implements an interface with JUST ONE abstract method
        Printer modernPrinter = data -> System.out.println(data);
        modernPrinter.print("Wassup");
        System.out.println(modernPrinter.getClass().getName());
    }
}

interface Printer {
    void print(String data);
    //void doSomething(String data);
}

class PrinterImpl implements Printer {
    public void print(String data) {
        System.out.println(data);
    }
}