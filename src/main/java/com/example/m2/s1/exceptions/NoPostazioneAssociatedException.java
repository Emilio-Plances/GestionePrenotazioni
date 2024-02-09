package com.example.m2.s1.exceptions;

public class NoPostazioneAssociatedException extends Exception{
    public NoPostazioneAssociatedException(){}

    public NoPostazioneAssociatedException(String message){
        super(message);
    }
}
