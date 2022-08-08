package com.tcv.hospital.repository;

import com.tcv.hospital.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
}
