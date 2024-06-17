package com.practo.controller;

import com.practo.entity.Doctor;
import com.practo.payload.DoctorDto;
import com.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody DoctorDto doctorDto){
        Doctor doctors = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(doctors, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>>  searchDoctors(@RequestParam String search){
        List<Doctor> doctors = doctorService.SearchDoctor(search);
        return new ResponseEntity<>(doctors,HttpStatus.OK);
    }
}
