package com.komaruStream.StreamByKomaru.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.komaruStream.StreamByKomaru.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void getEmployees() {
        Employee[] employees = employeeService.getEmployees();
        assertEquals(10, employees.length);
    }

    @Test
    void findEmployeeWithMaxSalaryFromDepartment() {
        Employee employee = employeeService.findEmployeeWithMaxSalaryFromDepartment(1);
        assertNotNull(employee);
        assertEquals("Неко Арк", employee.getName());
    }

    @Test
    void findEmployeeWithMinSalaryFromDepartment() {
        Employee employee = employeeService.findEmployeeWithMinSalaryFromDepartment(1);
        assertNotNull(employee);
        assertEquals("Вонави Нави", employee.getName());
    }

    @Test
    void findEmployeesFromDepartment() {
        List<Employee> employees = employeeService.findEmployeesFromDepartment(1);
        assertEquals(3, employees.size());
    }

    @Test
    void findEmployees() {
        List<Employee> employees = employeeService.findEmployees();
        assertEquals(10, employees.size());
    }
}
