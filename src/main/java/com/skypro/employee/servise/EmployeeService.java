package com.skypro.employee.servise;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee addEmployee(EmployeeRequest employeeRequest);
    Employee getEmployeeWithMinSalary();
    List<Employee> getEmployeesWithSalaryMoreAverage();
    int getSumOfSalaries();
    public Employee getEmployeeWithMaxSalary();
}
