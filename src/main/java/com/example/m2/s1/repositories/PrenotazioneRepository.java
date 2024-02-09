package com.example.m2.s1.repositories;

import com.example.m2.s1.entities.Postazione;
import com.example.m2.s1.entities.Prenotazione;
import com.example.m2.s1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
    @Query("SELECT p FROM Prenotazione p WHERE p.postazione=:postazione AND p.dataPrenotazione=:data")
    List<Prenotazione> searchByDataAndPostazione(LocalDate data, Postazione postazione);
    @Query("SELECT p FROM Prenotazione p WHERE p.utente=:utente AND p.dataPrenotazione=:data")
    List<Prenotazione> searchByDataAndUtente(LocalDate data, Utente utente);
}
