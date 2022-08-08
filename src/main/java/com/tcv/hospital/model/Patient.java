package com.tcv.hospital.model;

import com.sun.istack.NotNull;
import com.tcv.hospital.observer.PatientObserver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Observable {
    @Id
    @GeneratedValue
    Integer id;
    @NotNull
    String cnp;
    @OneToMany
    List<Visit> visitList = new ArrayList<>();
    @NotNull
    @ManyToOne
    Doctor doctor;
    @Transient
    PatientObserver patientObserver;

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
        patientObserver.update(this, patientObserver);
    }
}
