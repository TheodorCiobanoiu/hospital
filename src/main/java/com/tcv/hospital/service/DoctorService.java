package com.tcv.hospital.service;

import com.tcv.hospital.exceptions.NoDoctorException;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Patient;
import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.repository.DoctorRepository;
import com.tcv.hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor save(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public void addPatient(Integer doctorId, Integer patientId) throws NoDoctorException{
        Doctor doctor = doctorRepository.getById(doctorId);
        if(doctor == null){
           throw new NoDoctorException();
        }
        else {
            Patient patient = patientRepository.getById(patientId);
            if (patient != null) {
                doctor.addPatient(patient);
            }
        }
    }

    public List<Doctor> getAllBySpecialty(Specialty specialty){
        return doctorRepository.getAllBySpecialty(specialty);
    }


}
