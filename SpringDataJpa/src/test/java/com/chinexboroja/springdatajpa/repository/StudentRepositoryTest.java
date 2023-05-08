package com.chinexboroja.springdatajpa.repository;

import com.chinexboroja.springdatajpa.entity.Guardian;
import com.chinexboroja.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("ihediohachinedu21@gmail.com")
                .firstName("Chinedu")
                .lastName("Ihedioha")
                //.guardianName("Okey")
                //.guardianEmail("chrisdiohat@yahoo.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("Okeychi@gmail.com")
                .name("Okey")
                .mobile("99388399282")
                .build();

        Student student = Student.builder()
                .firstName("Chinex")
                .emailId("ihedioha@gmail.com")
                .lastName("Innocent")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student list: " + studentList);
    }
}