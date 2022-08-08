package com.tcv.hospital.dto;

import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private String name;
    private Specialty specialty;

    public DoctorDTO(Doctor doctor){
        this.name = doctor.getName();
        this.specialty = doctor.getSpecialty();
    }
}
