package com.practo.service;

import com.practo.entity.Patients;
import com.practo.payload.PatientDto;
import com.practo.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientsRepository  patientsRepository;

    public Patients addPatient(PatientDto patientDto){
        Patients patients = new Patients();
        patients.setPatientName(patientDto.getPatientName());
        patients.setAge(patientDto.getAge());
        patients.setSex(patientDto.getSex());
        patients.setDisease(patientDto.getDisease());

        Patients savedPatients = patientsRepository.save(patients);

        return savedPatients;

    }
}
