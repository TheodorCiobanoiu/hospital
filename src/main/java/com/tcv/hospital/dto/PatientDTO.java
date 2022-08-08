package com.tcv.hospital.dto;

import com.tcv.hospital.model.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO {
    String cnp;
    String doctorName;

    PatientDTO(Patient patient){
        this.cnp = patient.getCnp();
        this.doctorName=patient.getDoctor().getName();
    }
}
