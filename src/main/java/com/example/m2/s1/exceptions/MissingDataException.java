package com.example.m2.s1.exceptions;

public class MissingDataException extends Exception{
    public MissingDataException(){}
    public MissingDataException(String message){
        super(message);
    }
}
