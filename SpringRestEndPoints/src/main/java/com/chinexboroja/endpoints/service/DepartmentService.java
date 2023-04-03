package com.chinexboroja.endpoints.service;

import com.chinexboroja.endpoints.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> findAllDepartment();

    Optional<Department> findById(Long id);

    void deleteById(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String departmentName);
}
