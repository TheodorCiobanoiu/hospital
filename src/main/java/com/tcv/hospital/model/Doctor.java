package com.tcv.hospital.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import com.tcv.hospital.exceptions.NoDoctorException;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    @OneToMany
    @JsonManagedReference
    @ToString.Exclude
    List<Patient> patientList;
    Specialty specialty;

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
}
