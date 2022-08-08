package com.tcv.hospital.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    Patient patient;
    @ManyToOne

    Doctor doctor;
    Date date;
}
