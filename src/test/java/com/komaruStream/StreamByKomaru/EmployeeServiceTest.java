package com.komaruStream.StreamByKomaru;

import com.komaruStream.StreamByKomaru.model.Employee;
import com.komaruStream.StreamByKomaru.service.DepartmentService;
import com.komaruStream.StreamByKomaru.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Комару", 1, 200000);
        employees[1] = new Employee("Кокоа", 1, 50);
        employees[2] = new Employee("Комуги", 1, 10000);
        employees[3] = new Employee("Панчан", 2, 50000000);
        employees[4] = new Employee("Дапи", 2, 30000);

        when(employeeService.getEmployees()).thenReturn(Arrays.asList(employees));
    }

    @Test
    public void testGetMinSalary() {
        List<String> result = departmentService.getMinSalary((byte) 1);
        assertEquals(1, result.size());
        assertEquals("Employee{name='Комару', department=1, salary=200000}", result.get(0));
    }

    @Test
    public void testGetMaxSalary() {
        List<String> result = departmentService.getMaxSalary((byte) 1);
        assertEquals(1, result.size());
        assertEquals("Employee{name='Комару', department=1, salary=200000}", result.get(0));
    }

    @Test
    public void testGetMinSalaryNonExistentDepartment() {
        List<String> result = departmentService.getMinSalary((byte) 10);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetMaxSalaryNonExistentDepartment() {
        List<String> result = departmentService.getMaxSalary((byte) 10);
        assertEquals(0, result.size());
    }
}
