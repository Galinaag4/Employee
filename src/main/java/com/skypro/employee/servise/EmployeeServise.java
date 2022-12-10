package com.skypro.employee.servise;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServise {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public  Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (StringUtils.isBlank(employeeRequest.getFirstName()) || StringUtils.isBlank(employeeRequest.getLastName())) {
            throw new IllegalArgumentException(" Введите имя");
        }
        Employee employee = new Employee(StringUtils.capitalize(employeeRequest.getFirstName()),
                StringUtils.capitalize(employeeRequest.getLastName()),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getMinSalary() {
        return employees.values().stream()
                .min((s1, s2) -> s1.getSalary() - s2.getSalary())
                .get();
    }

    public Employee getMaxSalary() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .max();
    }

    public List<Employee> getEmployeesWithSalaryMoreThatAverage() {
        Double averageSalary = getAvarageSalary();
        if (averageSalary == null) {
            return Collections.emptyList();
        }
        return employees.values()
                .stream()
                .filter(e -> e.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }

    private Double getAvarageSalary() {
        return employees.values()
                .stream()
                .collect(Collectors.averagingInt(Employee::getSalary));
    }

    public Employee removeEmployee(int id) {
        return employees.remove(id);
    }


}

