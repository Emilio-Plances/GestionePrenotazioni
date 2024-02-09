package com.example.m2.s1.repositories;

import com.example.m2.s1.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio,Integer> {
}
