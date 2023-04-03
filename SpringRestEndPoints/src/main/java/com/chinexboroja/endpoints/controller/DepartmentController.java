package com.chinexboroja.endpoints.controller;

import com.chinexboroja.endpoints.model.Department;
import com.chinexboroja.endpoints.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping(value = "/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping(value = "/departments")
    public List<Department> fetchAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @GetMapping(value = "/departments/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }
}
