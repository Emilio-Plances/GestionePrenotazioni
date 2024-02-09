package com.example.m2.s1.services;

import com.example.m2.s1.entities.Postazione;
import com.example.m2.s1.entities.Prenotazione;
import com.example.m2.s1.entities.Utente;
import com.example.m2.s1.exceptions.*;
import com.example.m2.s1.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository pr;
    public void save(Prenotazione p) throws AlreadyOccupiedException, NoPostazioneAssociatedException, MissingUserException, UserAlreadyOccupied,MissingDataException{
        checkIfPossible(p);
        pr.save(p);
    }
    private void checkIfPossible(Prenotazione p) throws AlreadyOccupiedException, NoPostazioneAssociatedException, MissingUserException, UserAlreadyOccupied,MissingDataException {
        if(p.getDataPrenotazione()==null) throw new MissingDataException("Serve una data per impostare una prenotazione");
        if(p.getPostazione()==null) throw new NoPostazioneAssociatedException("Nessuna postazione è ancora associata a questa prenotazione");
        if(p.getUtente()==null) throw new MissingUserException("Nessun utente è ancora associato a questa prenotazione");
        if(!checkIfLocationFree(p.getDataPrenotazione(),p.getPostazione())) throw new AlreadyOccupiedException("Questa postazione è già occupata");
        if(!checkIfUserFree(p.getDataPrenotazione(),p.getUtente())) throw new UserAlreadyOccupied("L'utente, oggi,è già occupato in un'altra sede");
    }
    public Prenotazione findById(int id) throws NoSuchElementException {
        return pr.findById(id).get();
    }
    public void deleteById(int id){
        pr.deleteById(id);
    }
    public void delete(Prenotazione p){
        pr.delete(p);
    }
    public boolean checkIfLocationFree(LocalDate data, Postazione postazione){
        return pr.searchByDataAndPostazione(data,postazione).isEmpty();
    }
    public boolean checkIfUserFree(LocalDate data, Utente utente){
        return pr.searchByDataAndUtente(data, utente).isEmpty();
    }
}
