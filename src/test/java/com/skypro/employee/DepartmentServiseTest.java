package com.skypro.employee;

import com.skypro.employee.model.Employee;
import com.skypro.employee.servise.DepartmentServise;
import com.skypro.employee.servise.EmployeeServise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiseTest {
private final List<Employee> employees = List.of(
        new Employee("Test One","Test One",1,7000),
        new Employee("Test Two","Test Two",2,3000),
        new Employee("Test Three","Test Three",2,4000)

);
    @Mock
    EmployeeServise employeeServise;
    @InjectMocks
    DepartmentServise departmentServise;
    @BeforeEach
    public void setup(){
    when(employeeServise.getAllEmployees());
    .thenReturn(employees);
    }
    @Test
    void getEmployeesByDepartment(){
        Collection<Employee> employeeList = this.departmentServise.getDepartmentEmployees(1);
        assertThat(employeeList)
                .hasSize(3)
                .contains(
                        employees.get(0),
                        employees.get(1),
                        employees.get(2));


    }
    @Test
    void sumOfSalariesByDepartment(){
        int sum = this.departmentServise.getSumOfSalariesByDepartment(1);
        assertThat(sum).isEqualTo(14_000);
    }
    @Test
    void maxSalaryInDepartment(){
        OptionalInt max = this.departmentServise.getMaxSalaryByDepartment(2);
        assertThat(max).isEqualTo(7000);
    }
    @Test
    void minSalaryInDepartment(){
        OptionalInt min = this.departmentServise.getMinSalaryByDepartment(2);
        assertThat(min).isEqualTo(3000);
    }
    @Test
    void groupedEmployees(){
        Map<Integer,List<Employee>> groupedEmployees = this.departmentServise
                .getEmployeesGroupedByDepartments();
        assertThat(groupedEmployees)
                .hasSize(2)
                .containsEntry(1,List.of(employees.get(0),employees.get(1),employees.get(2)))
                .containsEntry(2,List.of(employees.get(3),employees.get(4)));

    }

}
