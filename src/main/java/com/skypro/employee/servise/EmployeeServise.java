package com.skypro.employee.servise;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

@Service
public class EmployeeServise {
    private final Map<Integer, Employee> employees = new HashMap<>();
    public Collection<Employee> getAllEmployees(){
        return this.employees.values();
    }
    public Employee addEmployee(EmployeeRequest employeeRequest){
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null){
            throw  new IllegalArgumentException(" Имя работника должно быть заполнено ");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
               ;
        this.employees.put(employee.getId(), employee);
        return employee;
    }
    public  int getSalarySum(){
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }
    public Employee getMinSalary(){
        return employees.values().stream()
                .min((s1,s2)-> s1.getSalary()-s2.getSalary())
                .get();
    }
    public OptionalInt getMaxSalary(){
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .max();
    }
    public int highSalary() {
        int average = getSalarySum()/employees.size();
        return (int) average;
    }

}
