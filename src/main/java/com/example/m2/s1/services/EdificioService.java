package com.example.m2.s1.services;

import com.example.m2.s1.entities.Edificio;
import com.example.m2.s1.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository er;
    public void save(Edificio e){
        er.save(e);
    }
    public Edificio findById(int id)throws NoSuchElementException {
        return er.findById(id).get();
    }
    public void deleteById(int id){
        er.deleteById(id);
    }
    public void delete(Edificio e){
        er.delete(e);
    }
}
