package com.geekster.Doctor.exception;

public class RecordNotFound extends RuntimeException{
    public RecordNotFound(String message){
        super(message);
    }
}
