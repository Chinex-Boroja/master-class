package com.chinexboroja.hibernateorm.repository.many_to_many;

import com.chinexboroja.hibernateorm.entity.many_to_many.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
