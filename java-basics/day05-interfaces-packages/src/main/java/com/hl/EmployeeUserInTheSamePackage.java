package com.hl;

public class EmployeeUserInTheSamePackage {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.level = 2;
        employee.designation = "Manager";
        employee.yearsOfExperience = 10;
    }
}

class Hello {

}