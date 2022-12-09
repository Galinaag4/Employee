package com.skypro.employee;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.servise.EmployeeServise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.OptionalInt;
import java.util.stream.Stream;


public class EmployeeServiseTest {
    private EmployeeServise employeeServise;
    @BeforeEach
    public void setup(){
        this.employeeServise = new EmployeeServise();
        Stream.of(
                new EmployeeRequest("Test One","Test One",1,7000),
                new EmployeeRequest("Test Two","Test Two",2,3000),
                new EmployeeRequest("Test Three","Test Three",2,4000)
        ).forEach(employeeServise::addEmployee);
    }
    @Test
    public void addEmployee(){
        EmployeeRequest request = new EmployeeRequest(
          "Valid", "Valid",3,5000
        );
        Employee result = employeeServise.addEmployee(request);
        assrtEquals(request.getFirstName(),result.getFirstName());
        assrtEquals(request.getLastName(),result.getLastName());
        assrtEquals(request.getSalary(),result.getSalary());
        assrtEquals(request.getDepartment(),result.getDepartment());
        Assertions
                .assertThat(employeeServise.getAllEmployees())
                .contains(result);

    }



    @Test
    public void listEmployees(){
        Collection<Employee> employees = employeeServise.getAllEmployees();
        Assertions.assertThat(employees).hasSize(5);
        Assertions.assertThat(employees)
                .first()
                .extracting(Employee::getFirstName)
                .isEqualTo("Test One");

    }
    @Test
    public void sumOfSalaries(){
        int sum = employeeServise.getSalarySum();
        Assertions.assertThat(sum).isEqualTo(35_000);

    }
    @Test
    public void employeeWithMaxSalary(){
      OptionalInt employee = employeeServise.getMaxSalary();
        Assertions.assertThat(employee)
                .inNotNull()
                .extracting(Employee::getFirstName)
                .isEqualTo("Test Three");


    }
    @Test
    public void removeEmployee(){
       employeeServise.removeEmployee(employeeServise.getAllEmployees().iterator().next().getId());
        Collection<Employee> employees = employeeServise.getAllEmployees();
        Assertions.assertThat(employees).hasSize(3);


    }
}
