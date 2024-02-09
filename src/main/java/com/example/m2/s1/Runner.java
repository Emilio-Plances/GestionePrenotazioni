package com.example.m2.s1;

import com.example.m2.s1.entities.Edificio;
import com.example.m2.s1.entities.Postazione;
import com.example.m2.s1.entities.Prenotazione;
import com.example.m2.s1.entities.Utente;
import com.example.m2.s1.enums.TipoPostazione;
import com.example.m2.s1.services.EdificioService;
import com.example.m2.s1.services.PostazioneService;
import com.example.m2.s1.services.PrenotazioneService;
import com.example.m2.s1.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger logger= LoggerFactory.getLogger("GestionePrenotazioni");
    @Autowired
    EdificioService es;
    @Autowired
    PostazioneService ps;
    @Autowired
    PrenotazioneService prs;
    @Autowired
    UtenteService us;
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);

        try{
            //Creazione utente
//            Utente u=ctx.getBean("utenteCompilato",Utente.class);
//            u.setNome("Emanuele");
//            u.setUsername("Barone");
//            us.save(u);
            Utente u=us.findById(2);

            //Creazione Edificio
//            Edificio e=ctx.getBean("edificioCompilato", Edificio.class);
//            es.save(e);
            Edificio e=es.findById(1);

            //Creazione Postazione
//            Postazione p=ctx.getBean("postazioneCompilata", Postazione.class);
//            p.setEdificio(e);
//            p.setTipoPostazione(TipoPostazione.OPENSPACE);
//            ps.save(p);
            Postazione p=ps.findById(2);

            //Creazione Prenotazione
//            Prenotazione pr=ctx.getBean("prenotazioneVuota", Prenotazione.class);
//            pr.setPostazione(p);
//            pr.setNumeroPartecipanti(10);
//            pr.setUtente(u);
//            prs.save(pr);
            Prenotazione pr=prs.findById(1);

            ps.searchByTipoAndCitta(TipoPostazione.PRIVATO,"Marsala").forEach(el->logger.info(el.toString()));
//            System.out.println(prs.checkIfLocationFree(LocalDate.now(),p));

        } catch (Exception e){
            logger.error(e.getMessage());
        }



    }
}
