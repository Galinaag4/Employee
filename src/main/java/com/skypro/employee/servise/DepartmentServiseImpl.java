package com.skypro.employee.servise;

import com.skypro.employee.employeesrepository.EmployeesRepository;
import com.skypro.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public abstract class DepartmentServiseImpl implements DepartmentServise{
    private final EmployeesRepository employeesRepository;
    @Autowired
    public DepartmentServiseImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }
    @Override
    public Set<Integer> getExistintDepartments(){
        return employeesRepository.getEmployees().stream()
                .map(Employee::getEmployeeDepartment)
                .collect(Collectors.toSet());
    }
    @Override
    public List<Employee>getEmployeesFromDepartment(int departmentId){
        return employeesRepository.getEmployees().stream()
                .filter(employee-> employee.getEmployeeDepartment() == departmentId)
                .collect(Collectors.toList());
    }
    @Override
    public int getSalarySumOfDepartment(int departmentId){
        return  getEmployeesFromDepartment(departmentId).stream()
                .mapToInt(Employee::getEmployeeSalary)
                .sum();

    }
    @Override
    public Map<Integer,List<Employee>>getEmployeesByDepartment(){
        return getExistintDepartments().stream()
                .collect(Collectors.toMap(dept -> dept,this::getEmployeesFromDepartment));
    }
    @Override
    public int getMinSalaryOfDepartment(int departmentId){
        return  getEmployeesFromDepartment(departmentId).stream()
                .mapToInt(Employee::getEmployeeSalary)
                .min().orElseThrow();

    }
    @Override
    public int getMaxSalaryOfDepartment(int departmentId){
        return  getEmployeesFromDepartment(departmentId).stream()
                .mapToInt(Employee::getEmployeeSalary)
                .max().orElseThrow();

    }
}


