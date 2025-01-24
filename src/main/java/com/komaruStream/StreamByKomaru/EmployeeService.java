package com.komaruStream.StreamByKomaru;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private static Employee[] employees = new Employee[10];

    public EmployeeService(Employee[] employee) {
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

    public static Employee[] getEmployees() {
        return employees;
    }

    public static OptionalInt findEmployeeWithMaxSalaryFromDepartment(int dep) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment() == dep)
                .mapToInt(Employee::getSalary)
                .max();
    }

    public static OptionalInt findEmployeeWithMinSalaryFromDepartment(int dep) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment() == dep)
                .mapToInt(Employee::getSalary)
                .min();
    }

    public static String findEmployeesFromDepartment(int dep) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment() == dep)
                .collect( Collectors.toList())
                .toString();
    }

    public static String findEmployees() {
        return Arrays.stream(employees)
                .toList().toString();
    }
}
