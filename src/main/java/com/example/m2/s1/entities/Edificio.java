package com.example.m2.s1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="edifici")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_edificio")
    @SequenceGenerator(name="sequenza_edificio",initialValue = 1,allocationSize = 1)
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio",cascade = CascadeType.REMOVE)
    private List<Postazione> listaPostazioni=new ArrayList<>();

    @Override
    public String toString() {
        return  "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'';
    }
}
