package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecensioneTest {

    @Test
    public void costruttore(){
        Recensione rec = new Recensione();
        @SuppressWarnings("deprecation")
		Date data = new Date(2022, 2, 3);
        rec.setData(data);
        rec.setIdDistributore(1);
        rec.setIdProdotto(2);
        rec.setTesto("rec");
        rec.setVoto(4);
        
        Date d = rec.getData();
        int id1 = rec.getIdDistributore();
        int id2 = rec.getIdProdotto();
        String t = rec.getTesto();
        int v = rec.getVoto();
        
        assertThat(d.toString().isEmpty()).isFalse();
        assertThat(id1 != 0);
        assertThat(id2 != 0);
        assertThat(t.isEmpty()).isFalse();
        assertThat(v != 0);

    }
}
