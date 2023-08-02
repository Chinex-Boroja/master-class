package com.chinexboroja.hibernateorm.service.many_to_many;

import com.chinexboroja.hibernateorm.entity.many_to_many.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);
}
