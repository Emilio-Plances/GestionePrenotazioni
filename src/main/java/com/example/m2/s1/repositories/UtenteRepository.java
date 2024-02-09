package com.example.m2.s1.repositories;

import com.example.m2.s1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
}
