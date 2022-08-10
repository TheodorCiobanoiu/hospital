package com.tcv.hospital.exceptions;


//When using enum for the specialties, Exception looks like is useless, because when we try to give an invalid specialty
//in Postman an MethodArgumentTypeMismatch exception is thrown and resolved by DefaultHandlerExceptionResolver, so our
//exception is never actually thrown

public class NoSpecialtyException extends Exception{
    public NoSpecialtyException(){
        super("This specialty doesn't exist!");
    }
}
