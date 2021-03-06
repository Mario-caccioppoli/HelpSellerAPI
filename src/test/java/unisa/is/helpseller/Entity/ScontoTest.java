package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import unisa.is.helpseller.Model.ScontoModel;

@SpringBootTest
public class ScontoTest {

    @Test
    public void costruttore(){
        Sconto s = new Sconto();
        @SuppressWarnings("deprecation")
		Date data = new Date(2022, 2, 3);
        s.setDataFine(data);
        s.setDataInizio(data);
        s.setIdAzienda(1);
        s.setNomeSconto("nome");
        s.setPercentuale(10);
        s.setQuantita(10);
        s.setTipo("quantita");
        
        Date d1 = s.getDataFine();
        Date d2 = s.getDataInizio();
        int id = s.getIdAzienda();
        String nome = s.getNomeSconto();
        int p = s.getPercentuale();
        int q = s.getQuantita();
        String tipo = s.getTipo();
        
        assertThat(d1.toString().isEmpty()).isFalse();
        assertThat(d2.toString().isEmpty()).isFalse();
        assertThat(id != 0);
        assertThat(nome.isEmpty()).isFalse();
        assertThat(p != 0);
        assertThat(q != 0);
        assertThat(tipo.isEmpty()).isFalse();


        ScontoModel s1 = new ScontoModel();
        s1.setId(1);s1.getDataFine();s1.setDataInizio(null);s1.setTipo("");s1.setQuantita(1);s1.setProdotti(null);
        s1.getProdotti();s1.setNomeSconto("");

    }
}
