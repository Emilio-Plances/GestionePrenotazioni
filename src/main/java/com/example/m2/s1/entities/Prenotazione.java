package com.example.m2.s1.entities;

import com.example.m2.s1.exceptions.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_prenotazione")
    @SequenceGenerator(name="sequenza_prenotazione",initialValue = 1,allocationSize = 1)
    private int id;
    @ManyToOne
    @JoinColumn(name="utente_fk")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name="postazione_fk")
    private Postazione postazione;
    private int numeroPartecipanti;
    private LocalDate dataPrenotazione;
    public void setNumeroPartecipanti(int numeroPartecipanti) throws ExceedMembersException,NoPostazioneAssociatedException,UserAlreadyOccupied {
        if(postazione==null) throw new NoPostazioneAssociatedException("Nessuna postazione è ancora associata a questa prenotazione");
        if(numeroPartecipanti>postazione.getNumeroMassimoPartecipanti()) throw new ExceedMembersException("Siete in troppi!");
        this.numeroPartecipanti = numeroPartecipanti;
    }
    @Override
    public String toString() {
        return  "id=" + id +
                ", utente=" + utente +
                ", postazione=" + postazione;
    }
}
