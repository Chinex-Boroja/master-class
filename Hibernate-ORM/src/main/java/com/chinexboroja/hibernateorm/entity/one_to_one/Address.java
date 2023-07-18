package com.chinexboroja.hibernateorm.entity.one_to_one;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    String street;
    String city;
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    User user;

}
