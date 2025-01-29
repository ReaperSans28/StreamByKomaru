package com.komaruStream.StreamByKomaru.controller;

import com.komaruStream.StreamByKomaru.model.Employee;
import com.komaruStream.StreamByKomaru.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departments")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/max-salary")
    public Employee employeeWithMaxSalaryFromDepartment(@PathParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMinSalaryFromDepartment(@PathParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMinSalaryFromDepartment(departmentId);
    }

    @GetMapping("/all-from-department")
    public String employeeFromDepartment(@PathParam("departmentId") int departmentId) {
        return employeeService.findEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/all")
    public String findEmployees() {
        return employeeService.findEmployees();
    }
}
