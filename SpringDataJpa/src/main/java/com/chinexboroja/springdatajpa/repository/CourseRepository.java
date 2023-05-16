package com.chinexboroja.springdatajpa.repository;

import com.chinexboroja.springdatajpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
