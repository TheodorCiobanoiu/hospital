package com.tcv.hospital.controller;

import com.tcv.hospital.exceptions.NoDoctorException;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Patient;
import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("doctors")

public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("{specialty}")
    public List<Doctor> getDoctorById(@PathVariable Specialty specialty){
        return doctorService.getAllBySpecialty(specialty);
    }

    @PostMapping("addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable Integer doctorId, @PathVariable Integer patientId) throws NoDoctorException {
        doctorService.addPatient(doctorId,patientId);
    }
    @PostMapping("save")
    public void saveDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
    }

}