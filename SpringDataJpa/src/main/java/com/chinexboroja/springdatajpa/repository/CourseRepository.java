package com.chinexboroja.springdatajpa.repository;

import com.chinexboroja.springdatajpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom method for pagination
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
