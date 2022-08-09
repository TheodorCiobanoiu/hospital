package com.tcv.hospital.dto;

import com.tcv.hospital.model.Specialty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {
    private String name;
    private Specialty specialty;
}
