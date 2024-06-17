package com.practo.payload;


import lombok.Data;

@Data
public class PatientDto {
    private Long id;

    private String patientName;

    private String disease;

    private Integer age;

    private String sex;

}