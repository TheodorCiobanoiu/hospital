package com.tcv.hospital.service;

import com.tcv.hospital.dto.DoctorDTO;
import com.tcv.hospital.exceptions.NoDoctorException;
import com.tcv.hospital.mapper.DoctorMapper;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Patient;
import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.repository.DoctorRepository;
import com.tcv.hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;
    final DoctorMapper doctorMapper;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public List<DoctorDTO> getAllDoctorsDTO(){
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void addPatient(Integer doctorId, Integer patientId) throws NoDoctorException{
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(!doctor.isPresent()){
           throw new NoDoctorException();
        }
        else {
            if (patient.isPresent()) {
                doctor.get().addPatient(patient.get());
                doctorRepository.save(doctor.get());
                patient.get().setDoctor(doctor.get());
                patient.get().setDoctorName();
                patientRepository.save(patient.get());
                System.out.println("All good. Added patient: " + patient + "\nTo doctor: " + doctor);
            }
        }

    }

    public List<Doctor> getAllBySpecialty(Specialty specialty){
        return doctorRepository.getAllBySpecialty(specialty);
    }

    public List<DoctorDTO> getAllBySpecialtyDTO(Specialty specialty){
        return doctorRepository.getAllBySpecialty(specialty).stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id){
        doctorRepository.deleteById(id);
    }


}
