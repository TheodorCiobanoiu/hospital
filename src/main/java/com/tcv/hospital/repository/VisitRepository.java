package com.tcv.hospital.repository;

import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
    List<Visit> findAllByPatient_Cnp(String cnp);
    List<Visit> findAllByDoctor_Specialty(Specialty specialty);
}
