package com.example.m2.s1.exceptions;

public class AlreadyOccupiedException extends Exception{
    public AlreadyOccupiedException(){}
    public AlreadyOccupiedException(String message){
        super(message);
    }
}
