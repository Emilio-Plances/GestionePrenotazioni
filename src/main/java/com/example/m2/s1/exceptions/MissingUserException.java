package com.example.m2.s1.exceptions;

public class MissingUserException extends Exception{
    public MissingUserException(){}
    public MissingUserException(String message){
            super(message);
        }
}
