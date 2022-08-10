package com.tcv.hospital.controller;

import com.tcv.hospital.dto.DoctorDTO;
import com.tcv.hospital.exceptions.NoDoctorException;
import com.tcv.hospital.exceptions.NoSpecialtyException;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Specialty;
import com.tcv.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("dto/all")
    public List<DoctorDTO> getAllDoctorsDTO(){
        return doctorService.getAllDoctorsDTO();
    }

    @GetMapping("specialty/{specialty}")
    public List<Doctor> getAllBySpecialty(@PathVariable Specialty specialty) throws NoSpecialtyException{
        try {
            return doctorService.getAllBySpecialty(specialty);
        } catch (MethodArgumentTypeMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping("dto/specialty/{specialty}")
    public List<DoctorDTO> getAllBySpecialtyDTO(@PathVariable Specialty specialty){
        return doctorService.getAllBySpecialtyDTO(specialty);
    }

    @PostMapping("addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable Integer doctorId, @PathVariable Integer patientId) {
        try {
            doctorService.addPatient(doctorId,patientId);
        } catch (NoDoctorException e) {
            System.out.println(e.getMessage());
        }
    }
    @PostMapping("save")
    public void saveDoctor(@RequestBody Doctor doctor){
        doctorService.save(doctor);
    }
    @DeleteMapping("delete/{id}")
    public void deleteDoctor(@PathVariable Integer id){
        doctorService.deleteById(id);
    }

}
