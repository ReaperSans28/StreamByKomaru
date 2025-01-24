package com.komaruStream.StreamByKomaru;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("departments")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/max-salary")
    public OptionalInt employeeWithMaxSalaryFromDepartment(@PathParam("departmentId") int departmentId) {
        return EmployeeService.findEmployeeWithMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public OptionalInt employeeWithMinSalaryFromDepartment(@PathParam("departmentId") int departmentId) {
        return EmployeeService.findEmployeeWithMinSalaryFromDepartment(departmentId);
    }

    @GetMapping("/all")
    public String employeeFromDepartment(@PathParam("departmentId") int departmentId) {
        return EmployeeService.findEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/alls")
    public String findEmployees() {
        return EmployeeService.findEmployees();
    }
}
