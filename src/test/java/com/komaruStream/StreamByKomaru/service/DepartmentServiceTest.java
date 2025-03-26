package com.komaruStream.StreamByKomaru.service;

import com.komaruStream.StreamByKomaru.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private EmployeeService employeeService;

    private Employee[] employees;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employees = new Employee[]{
                new Employee("Вонави Нави", 1, 50000),
                new Employee("Годжо Сатору", 2, 60000),
                new Employee("Сергей Талант", 3, 55000),
                new Employee("Быкова Наталия", 1, 70000),
                new Employee("Пиндер Кингви", 4, 45000),
                new Employee("Спардович Дэнчик", 5, 30000),
                new Employee("Мотивированный Виталик", 2, 80000),
                new Employee("Меривезер Санс", 3, 99999),
                new Employee("Щебень Толик", 4, 40000),
                new Employee("Неко Арк", 1, 1000000000)
        };
    }

    @Test
    void groupEmployeesByDepartment() {
        when(employeeService.getEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> result = departmentService.groupEmployeesByDepartment((byte) 1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(3, result.get(1).size());
        assertTrue(result.get(1).stream().anyMatch(e -> e.getName().equals("Вонави Нави")));
        assertTrue(result.get(1).stream().anyMatch(e -> e.getName().equals("Быкова Наталия")));
        assertTrue(result.get(1).stream().anyMatch(e -> e.getName().equals("Неко Арк")));
    }

    @Test
    void getMinSalary() {
        when(employeeService.getEmployees()).thenReturn(employees);
    
        int result = departmentService.getMinSalary((byte) 1);
    
        assertNotNull(result);
        assertEquals(50000, result);
    }

    @Test
    void getMaxSalary() {
        when(employeeService.getEmployees()).thenReturn(employees);

        int result = departmentService.getMaxSalary((byte) 1);

        assertNotNull(result);
        assertEquals(1000000000, result);
    }
}