package com.skypro.employee.employeesrepository;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class EmployeesRepository {
    private static int lastId;
    private final List<Employee> employees;

    public EmployeesRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public  List<Employee> getEmployees() {
        return employees;
    }

    public static int getLastId() {
        return lastId;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        ++lastId;
    }
}
