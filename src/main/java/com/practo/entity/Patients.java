package com.practo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "patient_name", nullable = false, length = 25)
    private String patientName;

    @Column(name = "disease", nullable = false, length = 25)
    private String disease;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "sex", nullable = false, length = 25)
    private String sex;

}