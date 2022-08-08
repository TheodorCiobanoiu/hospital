package com.tcv.hospital.exceptions;


public class NoDoctorException extends Exception{
    public NoDoctorException(){
        super("This doctor doesn't exist!");
    }
}
