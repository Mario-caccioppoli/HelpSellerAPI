package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdottoTest {

    @Test
    public void costruttore(){
        Prodotto prod = new Prodotto();

        prod.setDescrizione("aut");
        prod.setIdAzienda(2);
        prod.setImmagine("ad");
        prod.setNomeProdotto("nome");
        prod.setPeso(1);
        prod.setPrezzo(11);
        prod.setQuantita(12);
        prod.setQuantitaMinima(1);
        prod.setVolume(4);
        
        String d = prod.getDescrizione();
        int id = prod.getId();
        String img = prod.getImmagine();
        String nome = prod.getNomeProdotto();
        int peso = prod.getPeso();
        double prezzo = prod.getPrezzo();
        int q = prod.getQuantita();
        int qm = prod.getQuantitaMinima();
        int v = prod.getVolume();
        
        assertThat(d.isEmpty()).isFalse();
        assertThat(id != 0);
        assertThat(img.isEmpty()).isFalse();
        assertThat(nome.isEmpty()).isFalse();
        assertThat(peso != 0);
        assertThat(prezzo != 0);
        assertThat(q != 0);
        assertThat(qm != 0);
        assertThat(v != 0);
    }
}
