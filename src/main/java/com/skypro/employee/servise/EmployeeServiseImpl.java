package com.skypro.employee.servise;

import com.skypro.employee.employeesrepository.EmployeesRepository;
import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiseImpl implements EmployeeService {
    private EmployeesRepository employeesRepository;

    public EmployeeServiseImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employee> getEmployees() {
        return EmployeesRepository.getEmployees();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        final Employee newEmployee =
                createEmployeeFromRequest(employeeRequest, employeesRepository.getLastId());
        employeesRepository.addEmployee(newEmployee);
        return newEmployee;
    }


    public int getSumOfSalaries() {
        return employeesRepository.getEmployees().stream()
                .mapToInt(Employee::getEmployeeSalary)
                .sum();
    }

    public Employee getEmployeeWithMinSalary() {
        return employeesRepository.getEmployees().stream()
                .min(Comparator.comparingInt(Employee::getEmployeeSalary))
                .orElseGet(() -> null);
    }

    public Employee getEmployeeWithMaxSalary() {
        return employeesRepository.getEmployees().stream()
                .max(Comparator.comparingInt(Employee::getEmployeeSalary))
                .orElseGet(() -> null);
    }
    public List<Employee> getEmployeesWithSalaryMoreAverage(){
        final List<Employee> employees = employeesRepository.getEmployees();
        final int average = averageSalary(employees);
        return employees.stream()
                .filter(e -> e.getEmployeeSalary()>average)
                .collect(Collectors.toList());
    }
}
