package com.example.m2.s1.entities;

import com.example.m2.s1.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_postazione")
    @SequenceGenerator(name="sequenza_postazione",initialValue = 1,allocationSize = 1)
    private int id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_postazione")
    private TipoPostazione tipoPostazione;
    @Column(name="numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name="edificio_fk")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione",cascade = CascadeType.REMOVE)
    private List<Prenotazione> listaPrenotazioni=new ArrayList<>();

    @Override
    public String toString() {
        return  "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", edificio=" + edificio;
    }
}
