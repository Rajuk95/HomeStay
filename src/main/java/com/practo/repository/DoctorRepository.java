package com.practo.repository;

import com.practo.entity.Doctor;
import com.practo.payload.DoctorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("select d from Doctor d where d.doctorName like %:search or d.specializations like %:search or d.experience like %:search")
    List<Doctor> searchByNameOrSpecialization(@Param("search") String search);
}