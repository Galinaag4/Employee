package com.skypro.employee.servise;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServise {
    private final EmployeeServise employeeServise;

    public DepartmentServise(EmployeeServise employeeServise) {
        this.employeeServise = employeeServise;
    }
    public Collection<Employee>getDepartmentEmployees(int department){
        return getEmployeesByDepartmentStream(department)
                .collect(Collectors.toList());
    }
    public int getSumOfSalariesByDepartment(int department){
        return getEmployeesByDepartmentStream(department)
                .mapToInt(Employee::getSalary)
                .sum();
    }
    public OptionalInt getMaxSalaryByDepartment(int department){
        return getEmployeesByDepartmentStream(department)
                .mapToInt(Employee::getSalary)
                .max();


    }
    public OptionalInt getMinSalaryByDepartment(int department){
        return getEmployeesByDepartmentStream(department)
                .mapToInt(Employee::getSalary)
                .min();


    }
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartments(){
        return EmployeeServise.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    private Stream<Employee> getEmployeesByDepartmentStream(int department){
        return EmployeeServise.getAllEmployees()
                .stream()
                .filter(e->e.getDepartment()==department);
    }

}
