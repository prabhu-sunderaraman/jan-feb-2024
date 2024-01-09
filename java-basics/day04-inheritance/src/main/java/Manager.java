//public class Manager : Employee
public class Manager extends Employee {
    private int level;

    //public Manager(String name, long salary, int level) {
    //base(name, salary)
    public Manager(String name, long salary, int level) {
        super(name, salary);
        this.level = level;
    }

    //Overriding is very straightforward in Java
    //Just redefine the base class method with the same signature
    //In .NET it's different. You have to mark the base class method as overridable
    public void work(int hours) {
        System.out.println("Manager: %s is working for %s hours".formatted(super.getName(), hours));
    }
}
