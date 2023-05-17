package com.chinexboroja.springdatajpa.repository;

import com.chinexboroja.springdatajpa.entity.Course;
import com.chinexboroja.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseOOP = Course.builder()
                .title("OOP")
                .creditPoint(5)
                .build();

        Course courseHLP = Course.builder()
                .title("HLP")
                .creditPoint(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Prof Tunde")
                .lastName("Book")
//                .courses(List.of(courseOOP, courseHLP))
                .build();

        teacherRepository.save(teacher);
    }


}