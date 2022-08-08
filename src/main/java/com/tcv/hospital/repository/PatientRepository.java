package com.tcv.hospital.repository;

import com.tcv.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
}
