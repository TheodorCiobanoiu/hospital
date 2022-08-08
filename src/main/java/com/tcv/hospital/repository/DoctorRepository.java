package com.tcv.hospital.repository;

import com.tcv.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
}
