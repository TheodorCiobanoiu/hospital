package com.tcv.hospital.observer;

import java.util.Observable;
import java.util.Observer;

public class PatientObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("You have a new patient");
    }
}
