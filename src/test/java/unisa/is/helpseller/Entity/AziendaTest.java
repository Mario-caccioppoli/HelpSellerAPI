package unisa.is.helpseller.Entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import unisa.is.helpseller.Model.AziendaModel;

@SpringBootTest
public class AziendaTest {

    @Test
    public void costruttore(){
        AziendaModel azienda = new AziendaModel("emailAziendaTest@email.it", "password",
                "AziendaTest", "99", "via vai", "azienda di prova", "", null, null);
        azienda.getEmail();azienda.getId();azienda.getPassword();azienda.getNomeAzienda();azienda.getDescrizione();azienda.getIndirizzo();azienda.getLogo();
        azienda.getVat();azienda.getOrdini();azienda.getProdotti();
        azienda.setEmail("");azienda.setId(66);azienda.setPassword("");azienda.setNomeAzienda("");azienda.setDescrizione("");azienda.setIndirizzo("");azienda.setLogo("");
        azienda.setVat("");azienda.setOrdini(null);azienda.setProdotti(null);
    }
}
