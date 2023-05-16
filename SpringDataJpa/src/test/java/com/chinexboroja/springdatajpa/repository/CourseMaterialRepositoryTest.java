package com.chinexboroja.springdatajpa.repository;

import com.chinexboroja.springdatajpa.entity.Course;
import com.chinexboroja.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    Course course = Course.builder()
            .title("CPE502")
            .creditPoint(5)
            .build();
    @Test
    public void saveCourseMaterial() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.cpe502.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }
}