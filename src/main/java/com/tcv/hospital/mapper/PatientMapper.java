package com.tcv.hospital.mapper;

import com.tcv.hospital.dto.PatientDTO;
import com.tcv.hospital.model.Doctor;
import com.tcv.hospital.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toPatientDTO(Patient patient);
}
