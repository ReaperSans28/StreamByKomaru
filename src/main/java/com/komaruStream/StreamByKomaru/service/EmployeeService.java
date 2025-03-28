package com.komaruStream.StreamByKomaru.service;

import com.komaruStream.StreamByKomaru.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Service
public class EmployeeService {

    private static final Employee[] employees = new Employee[10];

    public EmployeeService() {
        employees[0] = new Employee("Вонави Нави", 1, 50000);
        employees[1] = new Employee("Годжо Сатору", 2, 60000);
        employees[2] = new Employee("Сергей Талант", 3, 55000);
        employees[3] = new Employee("Быкова Наталия", 1, 70000);
        employees[4] = new Employee("Пиндер Кингви", 4, 45000);
        employees[5] = new Employee("Спардович Дэнчик", 5, 30000);
        employees[6] = new Employee("Мотивированный Виталик", 2, 80000);
        employees[7] = new Employee("Меривезер Санс", 3, 99999);
        employees[8] = new Employee("Щебень Толик", 4, 40000);
        employees[9] = new Employee("Неко Арк", 1, 1000000000);
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int dep) {
        EmployeeService employeeService = new EmployeeService();
        return Arrays.stream(employeeService.getEmployees())
                .filter(employee -> employee.getDepartment() == dep)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }


    public Employee findEmployeeWithMinSalaryFromDepartment(int dep) {
        EmployeeService employeeService = new EmployeeService();
        return Arrays.stream(employeeService.getEmployees())
                .filter(employee -> employee.getDepartment() == dep)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> findEmployeesFromDepartment(int dep) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment() == dep)
                .toList();
    }

    public List<Employee> findEmployees() {
        return Arrays.stream(employees)
                .toList();
    }
}
