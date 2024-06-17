package com.practo.service;

import com.practo.entity.Doctor;
import com.practo.payload.DoctorDto;
import com.practo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(DoctorDto doctorDto){

        Doctor doctor = new Doctor();
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setDescription(doctorDto.getDescription());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setQualification(doctorDto.getQualification());
        doctor.setSpecializations(doctorDto.getSpecializations());

        Doctor saved = doctorRepository.save(doctor);

        return saved;
    }

    public List<Doctor> SearchDoctor(String search){
        List<Doctor> doctors = doctorRepository.searchByNameOrSpecialization(search);
        return doctors;
    }
}
