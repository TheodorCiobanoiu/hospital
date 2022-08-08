package com.tcv.hospital.repository;

import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
    Doctor getById(Integer id);
    List<Doctor> getAllBySpecialty(Specialty specialty);
}
