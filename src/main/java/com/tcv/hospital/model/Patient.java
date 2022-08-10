package com.tcv.hospital.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    @NotNull
    String cnp;
    @OneToMany
    List<Visit> visitList = new ArrayList<>();
    @ManyToOne
//    Annotation used so when getting an Doctor from the db we don't have an infinite loop
//    because of the bidirectional relation between Patient and Doctor
    @JsonBackReference
    Doctor doctor;
    String doctorName; // Used only for the PatientDTO. Could not find a better way to get the doctor's name and save it in the DTO
    public void setDoctorName(){
        this.doctorName = this.doctor.getName();
    }

}
