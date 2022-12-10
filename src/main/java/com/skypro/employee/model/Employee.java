package com.skypro.employee.model;

public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private int salary;
    private int department;
    private static int counter;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        id = counter++;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }


}
