package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.servise.EmployeeServise;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;

@RestController
public class EmployeeController {
    private final EmployeeServise employeeServise;

    public EmployeeController (EmployeeServise employeeServise){
        this.employeeServise= employeeServise;
    }
    @GetMapping("/employees")
    public Collection<Employee>getAllEmployees(){
        return  this.employeeServise.getAllEmployees();

    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
      return   this.employeeServise.addEmployee(employeeRequest);
    }
    @GetMapping("/employees/salary/sum")
    public int getSalarySum(){
        return  this.employeeServise.getSalarySum();
    }
    @GetMapping("/employees/salary/min")
    public Employee getMinSalary(){
        return  this.employeeServise.getMinSalary();
    }
    @GetMapping("/employees/salary/max")
    public OptionalInt getMaxSalary(){
        return  this.employeeServise.getMaxSalary();
    }
    @GetMapping("/employees/salary/highSalary")
    public List<Employee> highSalary(){
        return  this.employeeServise.getEmployeesWithSalaryMoreThatAverage();
    }
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(IllegalArgumentException e){
        return "400 Bad Reques";
    }



}
