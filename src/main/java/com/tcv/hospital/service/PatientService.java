package com.tcv.hospital.service;

import com.tcv.hospital.dto.PatientDTO;
import com.tcv.hospital.mapper.PatientMapper;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Patient;
import com.tcv.hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    final PatientRepository patientRepository;
    final PatientMapper patientMapper;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Patient getPatientById(Integer id){
        return patientRepository.getById(id);
    }

    public List<PatientDTO> getAllPatientsDTO(){
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }
    public PatientDTO getPatientDTOById(Integer id){
        return patientMapper.toPatientDTO(patientRepository.getById(id));
    }

    public List<Patient> getAllByDoctor(Doctor doctor){
        return patientRepository.getAllByDoctor(doctor);
    }

    public List<PatientDTO> getAllDTOByDoctor(Doctor doctor){
        return patientRepository.getAllByDoctor(doctor).stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

    public Patient getByCNP(String cnp){
        return patientRepository.getByCnp(cnp);
    }

    public void savePatient(Patient patient){
        patientRepository.save(patient);
    }
}
