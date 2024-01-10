import com.hl.Employee;

public class EmployeeUserInDifferentPackage {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.designation = "Manager";
        //employee.level = 2;
        //employee.yearsOfExperience = 10;
        //Hello hello = new Hello();
    }
}
class Manager extends Employee {
    public void printInfo() {
        System.out.println(super.yearsOfExperience);
    }
}