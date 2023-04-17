package com.chinexboroja.endpoints.service;

import com.chinexboroja.endpoints.model.Department;
import com.chinexboroja.endpoints.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("EEE")
                        .departmentAddress("Isolo")
                        .departmentCode("EE-01")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findDepartmentByDepartmentNameIgnoreCase("EEE"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get data based on valid department's name")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        String departmentName = "EEE";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}