package com.komaruStream.StreamByKomaru.service;

import com.komaruStream.StreamByKomaru.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentService {

    @Autowired
    private EmployeeService employeeService;

    public Map<Integer, List<Employee>> groupEmployeesByDepartment(byte departmentId) {
        return Arrays.stream(employeeService.getEmployees())
                .filter(employee -> employee != null && employee.getDepartment() == departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public int getMinSalary(byte departmentId) {
        return Arrays.stream(employeeService.getEmployees())
                .filter(employee -> employee != null && employee.getDepartment() == departmentId)
                .mapToInt(Employee::getSalary)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Нет сотрудников в отделе " + departmentId));
    }


    public int getMaxSalary(byte departmentId) {
        return Arrays.stream(employeeService.getEmployees())
                .filter(employee -> employee != null && employee.getDepartment() == departmentId)
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Нет сотрудников в отделе " + departmentId));
    }
}