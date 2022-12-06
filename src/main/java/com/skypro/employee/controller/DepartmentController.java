package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.servise.DepartmentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServise departmentServise;
    @Autowired
    public DepartmentController(DepartmentServise departmentServise) {
        this.departmentServise = departmentServise;
    }
    @GetMapping
    public String getExistintDepartments(){
        return "Existing department:" + departmentServise.getExistingDepartments().toString();
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesByDepartment(){
     return departmentServise.getEmployeesByDepartment();
    }
    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesFromDepartment(@PathVariable("id") int departmentId){
        return departmentServise.getEmployeesFromDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOfDepartment(@PathVariable("id") int departmentId){
        return departmentServise.getSalarySumOfDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/min")
    public int getMinSalaryOfDepartment(@PathVariable("id") int departmentId){
        return departmentServise.getMinSalaryOfDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryOfDepartment(@PathVariable("id") int departmentId){
        return departmentServise.getMaxSalaryOfDepartment(departmentId);
    }

}
