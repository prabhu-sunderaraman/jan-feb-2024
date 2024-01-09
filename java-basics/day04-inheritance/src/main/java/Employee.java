public class Employee {
    private String name;
    private long salary;

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public void work(int hours) {
        System.out.println("Employee: %s is working for %s hours".formatted(name, hours));
    }
}
