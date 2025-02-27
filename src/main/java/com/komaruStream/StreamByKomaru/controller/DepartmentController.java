package com.komaruStream.StreamByKomaru.controller;

import com.komaruStream.StreamByKomaru.model.Employee;
import com.komaruStream.StreamByKomaru.service.DepartmentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentServies;

    @Autowired
    public DepartmentController(DepartmentService departmentServies) {
        this.departmentServies = departmentServies;
    }

    @GetMapping(path = "/max-salary")
    public List<String> findMaxSalary(@PathParam("departmentId") byte departmentId) {
        return departmentServies.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public List<String> findMinSalary(@PathParam("departmentId") byte departmentId) {
        return departmentServies.getMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findAllEmployeeOnDepartament(@PathParam("departmentId") byte departmentId) {
        return departmentServies.groupEmployeesByDepartment(departmentId);
    }
}
