public class OOBasics {
    public static void main(String[] args) {

        Truck tesla = new Truck("Tesla", 300000);
        System.out.println(tesla.getModel());
        System.out.println(tesla.getPrice());
        //tesla.price = 324234234;
        tesla.setPrice(400000);


        Company hl = new Company("Herbalife", 5000);
        System.out.println(hl.name);
        System.out.println(hl.employeeCount);

//        hl.name = "Herbalife";
//        hl.employeeCount = 5000;


        Book javaBook = new Book();
        javaBook.title = "Thinking in Java";
        javaBook.price = 45.56;
        javaBook.publisher = new Publisher();
        javaBook.read();


        Car myCar = new Car();
        //myCar is an instance of Car class
        //myCar is a reference to Car class object
        //myCar is an object
        System.out.println(myCar.model);
        System.out.println(myCar.yearOfMake);

        myCar.model = "BMW";
        myCar.yearOfMake = 2020;
        myCar.drive();
        myCar.applyBrakes();
    }
}
