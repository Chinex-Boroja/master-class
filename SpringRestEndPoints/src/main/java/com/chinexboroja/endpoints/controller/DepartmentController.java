package com.chinexboroja.endpoints.controller;

import com.chinexboroja.endpoints.exceptions.DepartmentNotFoundException;
import com.chinexboroja.endpoints.model.Department;
import com.chinexboroja.endpoints.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping(value = "/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping(value = "/departments")
    public List<Department> fetchAllDepartment() {
        LOGGER.info("Inside fetchAllDepartment of DepartmentController");
        return departmentService.findAllDepartment();
    }

    @GetMapping(value = "/departments/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.findById(id);
    }

    @DeleteMapping(value = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteById(id);
        return "Department deleted successfully!!";
    }

    @PutMapping(value = "/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
