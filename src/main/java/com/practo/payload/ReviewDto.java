package com.practo.payload;


import lombok.Data;

@Data
public class ReviewDto {
    private Long doctorId;
    private Long patientId;
    private Integer rating;
}

