package com.komaruStream.StreamByKomaru.service;
import com.komaruStream.StreamByKomaru.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;


@Service
public class DepartmentService {

    @Autowired
    private EmployeeService employeeService;

    public Map<Integer, List<Employee>> groupEmployeesByDepartment(byte departmentId) {
        return Arrays.stream( EmployeeService.getEmployees() )
                .filter( employee -> employee != null && employee.getDepartment() == departmentId )
                .collect( Collectors.groupingBy( Employee::getDepartment ) );
    }

    public List<String> getMinSalary(byte departmentId) {
        OptionalInt minSalary = Arrays.stream( EmployeeService.getEmployees() )
                .filter( employee -> employee != null && employee.getDepartment() == departmentId )
                .mapToInt( Employee::getSalary )
                .min();

        if (minSalary.isPresent()) {
            return Arrays.stream( EmployeeService.getEmployees() )
                    .filter( employee -> employee != null && employee.getDepartment() == departmentId && employee.getSalary() == minSalary.getAsInt() )
                    .map( Employee::toString )
                    .collect( Collectors.toList() );
        } else {
            return List.of();
        }
    }

    public List<String> getMaxSalary(byte departmentId) {
        OptionalInt maxSalary = Arrays.stream( EmployeeService.getEmployees() )
                .filter( employee -> employee != null && employee.getDepartment() == departmentId )
                .mapToInt( Employee::getSalary )
                .max();

        if (maxSalary.isPresent()) {
            return Arrays.stream( EmployeeService.getEmployees() )
                    .filter( employee -> employee != null && employee.getDepartment() == departmentId && employee.getSalary() == maxSalary.getAsInt() )
                    .map( Employee::toString )
                    .collect( Collectors.toList() );
        } else {
            return List.of();
        }
    }
}
