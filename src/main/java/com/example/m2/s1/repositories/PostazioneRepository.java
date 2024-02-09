package com.example.m2.s1.repositories;

import com.example.m2.s1.entities.Postazione;
import com.example.m2.s1.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {
    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione=:tipoPostazione AND p.edificio.citta=:citta")
    List<Postazione> searchByTipoAndCitta(TipoPostazione tipoPostazione, String citta);
}
