package com.tcv.hospital.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    @OneToMany
//    Annotation used so when getting a Doctor from the db we don't have an infinite loop
//    because of the bidirectional relation between Patient and Doctor
    @JsonManagedReference
    @ToString.Exclude
    List<Patient> patientList;
    Specialty specialty;

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
}
