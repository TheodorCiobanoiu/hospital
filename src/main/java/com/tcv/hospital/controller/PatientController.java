package com.tcv.hospital.controller;

import com.tcv.hospital.dto.PatientDTO;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Patient;
import com.tcv.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("dto/all")
    public List<PatientDTO> getAllPatientsDTO(){
        return patientService.getAllPatientsDTO();
    }

    @GetMapping("id/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }

    @GetMapping("dto/id/{id}")
    public PatientDTO getPatientDTOById(@PathVariable Integer id){
        return patientService.getPatientDTOById(id);
    }

    @GetMapping("doctor")
    public List<Patient> getAllPatientsByDoctor(@RequestBody Doctor doctor){
        return patientService.getAllByDoctor(doctor);
    }

    @GetMapping("dto/doctor")
    public List<PatientDTO> getAllDTOByDoctor(@RequestBody Doctor doctor){
        return patientService.getAllDTOByDoctor(doctor);
    }

    @GetMapping("cnp/{cnp}")
    public Patient getPatientByCnp(@PathVariable String cnp){
        return patientService.getByCnp(cnp);
    }

    @GetMapping("/dto/cnp/{cnp}")
    public PatientDTO getPatientDTObyCnp(@PathVariable String cnp){
        return patientService.getByCnpDTO(cnp);
    }

    @PostMapping("save")
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }



}
