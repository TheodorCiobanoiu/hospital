package com.tcv.hospital.exceptions;

public class NoSpecialtyException extends Exception{
    public NoSpecialtyException(){
        super("This specialty doesn't exist!");
    }
}
