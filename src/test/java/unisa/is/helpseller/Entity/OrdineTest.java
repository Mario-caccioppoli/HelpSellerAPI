package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import unisa.is.helpseller.Model.OrdineModel;

@SpringBootTest
public class OrdineTest {

    @Test
    public void costruttore(){
        Ordine ord = new Ordine();
        @SuppressWarnings("deprecation")
		Date data = new Date(2022, 2, 3);
        ord.setCommento("aut");
        ord.setDataConsegna(data);
        ord.setDataOrdinazione(data);
        ord.setIdDistributore(2);
        ord.setStato("ok");
        
        String c = ord.getCommento();
        Date d1 = ord.getDataConsegna();
        Date d2 = ord.getDataOrdinazione();
        int id = ord.getIdDistributore();
        String s = ord.getStato();
        
        assertThat(c.isEmpty()).isFalse();
        assertThat(d1.equals(null)).isFalse();
        assertThat(d2.equals(null)).isFalse();
        assertThat(id != 0);
        assertThat(s.isEmpty()).isFalse();

        OrdineModel o = new OrdineModel();
        o.setId(1);o.setDataOrdinazione(null);o.setStato("");o.getStato();o.getDocumento();
        o.setDocumento(null);o.getPrezzoTotale();o.setPrezzoTotale(1);o.setOrdineProdotti(null);

    }
}
