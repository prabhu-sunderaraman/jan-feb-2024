public class InheritanceMain {
    public static void main(String[] args) {
        Employee emp = new Employee("Sam", 3321421);
        emp.work(8);
        Manager manager = new Manager("Ram", 4234324, 4);
        manager.work(10);
        Employee emp2 = new Manager("Mary", 324234,4);
        emp2.work(10); //Called polymorphically
    }
}
