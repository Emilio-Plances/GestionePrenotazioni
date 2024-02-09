package com.example.m2.s1;

import com.example.m2.s1.entities.Edificio;
import com.example.m2.s1.entities.Postazione;
import com.example.m2.s1.entities.Prenotazione;
import com.example.m2.s1.entities.Utente;
import com.example.m2.s1.enums.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean("utenteVuoto")
    @Scope("prototype")
    public Utente getUtenteVuoto(){
        return new Utente();
    }
    @Bean("utenteCompilato")
    @Scope("prototype")
    public Utente getUtenteCompilato(){
        Utente u=new Utente();
        u.setEmail("Emilio.Plances@gmail.com");
        u.setNome("Emilio");
        u.setCognome("Plances");
        u.setUsername("Asura");
        return u;
    }

    @Bean("edificioVuoto")
    @Scope("prototype")
    public Edificio getEdificioVuoto(){
        return new Edificio();
    }
    @Bean("edificioCompilato")
    @Scope("prototype")
    public Edificio getEdificioCompilato(){
        Edificio e=new Edificio();
        e.setNome("Palazzo Bello");
        e.setCitta("Marsala");
        e.setIndirizzo("Via Bella");
        return e;
    }

    @Bean("postazioneVuota")
    @Scope("prototype")
    public Postazione getPostazioneVuota(){
        return new Postazione();
    }
    @Bean("postazioneCompilata")
    @Scope("prototype")
    public Postazione getPostazioneCompilata(){
        Postazione p=new Postazione();
        p.setDescrizione("Una postazione molto bella");
        p.setTipoPostazione(TipoPostazione.PRIVATO);
        p.setNumeroMassimoPartecipanti(10);
        return p;
    }

    @Bean("prenotazioneVuota")
    @Scope("prototype")
    public Prenotazione getPrenotazioneVuota(){
        return new Prenotazione();
    }
}
