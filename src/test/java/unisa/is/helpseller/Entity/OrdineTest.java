package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrdineTest {

    @Test
    public void costruttore(){
        Ordine ord = new Ordine();
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
    }
}
