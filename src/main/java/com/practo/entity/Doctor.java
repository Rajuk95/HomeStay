package com.practo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "doctor_name", nullable = false, length = 20)
    private String doctorName;

    @Column(name = "qualification", nullable = false, length = 25)
    private String qualification;

    @Column(name = "specializations", nullable = false, length = 25)
    private String specializations;

    @Column(name = "experience", nullable = false, length = 25)
    private String experience;

    @Column(name = "description", nullable = false, length = 2500)
    private String description;

}