package com.example.m2.s1.services;

import com.example.m2.s1.entities.Postazione;
import com.example.m2.s1.enums.TipoPostazione;
import com.example.m2.s1.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository pr;
    public void save(Postazione p){
        pr.save(p);
    }
    public Postazione findById(int id) throws NoSuchElementException {
        return pr.findById(id).get();
    }
    public void deleteById(int id){
        pr.deleteById(id);
    }
    public void delete(Postazione p){
        pr.delete(p);
    }
    public List<Postazione> searchByTipoAndCitta(TipoPostazione tipoPostazione,String citta){
        return pr.searchByTipoAndCitta(tipoPostazione,citta);
    }
}
