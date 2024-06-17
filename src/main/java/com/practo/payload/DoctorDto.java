package com.practo.payload;


import lombok.Data;

@Data
public class DoctorDto {
    private Long id;

    private String doctorName;

    private String qualification;

    private String specializations;

    private String experience;

    private String description;

}