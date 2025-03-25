package com.komaruStream.StreamByKomaru.controller;

import com.komaruStream.StreamByKomaru.model.Employee;
import com.komaruStream.StreamByKomaru.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public int findMaxSalary(@RequestParam("departmentId") byte departmentId) {
        return departmentService.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public int findMinSalary(@RequestParam("departmentId") byte departmentId) {
        return departmentService.getMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findAllEmployeeOnDepartment(@RequestParam("departmentId") byte departmentId) {
        return departmentService.groupEmployeesByDepartment(departmentId);
    }
}