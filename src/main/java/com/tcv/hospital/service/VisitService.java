package com.tcv.hospital.service;

import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.model.Visit;
import com.tcv.hospital.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    final VisitRepository visitRepository;

    public List<Visit> getAllVisits(){
        return visitRepository.findAll();
    }

    public List<Visit> getVisitsByCnp(String cnp){
        return visitRepository.findAllByPatient_Cnp(cnp);
    }

    public List<Visit> getVisitBySpecialty(Specialty specialty){
        return visitRepository.findAllByDoctor_Specialty(specialty);
    }

    public void saveVisit(Visit visit){
        visitRepository.save(visit);
    }

}
