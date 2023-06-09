package com.chinexboroja.springdatajpa.repository;

import com.chinexboroja.springdatajpa.entity.Course;
import com.chinexboroja.springdatajpa.entity.Student;
import com.chinexboroja.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: " + courses);
    }
    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Chinedu")
                .lastName("Ihedioha")
                .build();

        Course course = Course
                .builder()
                .title("Java")
                .creditPoint(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages: " + totalPages);

        System.out.println("totalElements: " + totalElements);

        System.out.println("Course: " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("creditPoint").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title")
                .descending().and(Sort.by("credit")));


        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses:" + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("A", firstPageTenRecords).getContent();

        System.out.println("courses: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeachers() {
        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Niklos")
                .lastName("Anek")
                .emailId("Nex@gmail.com")
                .build();

        Course course = Course.builder()
                .title("NLP")
                .creditPoint(5)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}