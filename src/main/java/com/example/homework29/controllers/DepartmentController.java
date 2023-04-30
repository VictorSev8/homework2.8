package com.example.homework29.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.homework29.Application;
import com.example.homework29.model.Employee;
import com.example.homework29.services.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "Welcome";
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryInDept(@RequestParam("departmentId") Integer id) {
        return service.findMaxSalaryInDept(id);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryInDept(@RequestParam("departmentId") Integer id) {
        return service.findMinSalaryInDept(id);
    }

    @GetMapping("/all")
    public List<Employee> findEmployeeFromDepartment(@RequestParam(value = "departmentId", required = false) Integer department) {
        if(department != null){
            return service.findEmployeeFromDepartment(department);
        } else {
            return service.findAllEmployeesFromDepartment();
        }
    }
    }
}