package com.skypro.employee.servise;

import com.skypro.employee.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentServise {
    public Set<Integer> getExistintDepartments();
    public List<Employee> getEmployeesFromDepartment();
   public int getSalarySumOfDepartment();

    List<Employee>getEmployeesFromDepartment(int departmentId);

    int getSalarySumOfDepartment(int departmentId);

    public Map<Integer,List<Employee>> getEmployeesByDepartment();
    public int getMinSalaryOfDepartment();
    public int getMaxSalaryOfDepartment();

    int getMinSalaryOfDepartment(int departmentId);

    int getMaxSalaryOfDepartment(int departmentId);
}
