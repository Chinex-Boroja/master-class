package com.chinexboroja.endpoints.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add department's name")
//    @Length(max = 5, min = 1)
//    @Size(max = 6, min = 5)
//    @Email
//    @Positive
//    @Negative
//    @Future

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
