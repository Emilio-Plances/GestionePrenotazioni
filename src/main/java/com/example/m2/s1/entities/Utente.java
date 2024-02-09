package com.example.m2.s1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_utente")
    @SequenceGenerator(name="sequenza_utente",initialValue = 1,allocationSize = 1)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;

    @OneToMany(mappedBy = "utente",cascade = CascadeType.REMOVE)
    List<Prenotazione> listaPrenotazioni=new ArrayList<>();

    @Override
    public String toString() {
        return  "id=" + id +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'';
    }
}
