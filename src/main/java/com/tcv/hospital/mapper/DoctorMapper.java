package com.tcv.hospital.mapper;

import com.tcv.hospital.dto.DoctorDTO;
import com.tcv.hospital.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor Doctor);
}
