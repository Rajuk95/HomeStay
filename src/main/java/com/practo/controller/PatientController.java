package com.practo.controller;

import com.practo.entity.Patients;
import com.practo.payload.PatientDto;
import com.practo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> addPatient(@RequestBody PatientDto patientDto){
        Patients patients = patientService.addPatient(patientDto);
        return new ResponseEntity<>(patients, HttpStatus.CREATED);
    }
}
