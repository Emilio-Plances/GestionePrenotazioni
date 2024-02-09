package com.example.m2.s1.exceptions;

public class UserAlreadyOccupied extends Exception{
    public UserAlreadyOccupied(){}
    public UserAlreadyOccupied(String message){
        super(message);
    }
}
