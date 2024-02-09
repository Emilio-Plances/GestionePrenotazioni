package com.example.m2.s1.services;

import com.example.m2.s1.entities.Edificio;
import com.example.m2.s1.entities.Utente;
import com.example.m2.s1.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository ur;
    public void save(Utente p){
        ur.save(p);
    }
    public Utente findById(int id) throws NoSuchElementException {
        return ur.findById(id).get();
    }
    public void deleteById(int id){
        ur.deleteById(id);
    }
    public void delete(Utente u){
        ur.delete(u);
    }
}
