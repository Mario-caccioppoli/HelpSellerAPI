package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import unisa.is.helpseller.Model.ScontoProdottoModel;

@SpringBootTest
public class ScontoProdottoTest {

    @Test
    public void costruttore(){
        ScontoProdotto sp = new ScontoProdotto();
        sp.setIdProdotto(1);
        sp.setIdSconto(2);
        
        int id1 = sp.getIdProdotto();
        int id2 = sp.getIdSconto();
        
        assertThat(id1 != 0);
        assertThat(id2 != 0);

        ScontoProdottoId a = new ScontoProdottoId();
        ScontoProdottoId sp2 = new ScontoProdottoId(1, 2);
        sp2.hashCode();
        sp2.equals(sp);
        sp2.getIdProdotto();
        sp2.getIdSconto();
        sp2.setIdProdotto(2);
        sp2.setIdSconto(1);

        ScontoProdottoModel sp3 = new ScontoProdottoModel(null, null);
        sp3.setProdotto(null);sp3.setSconto(null);
        sp3.getProdotto();sp3.getSconto();

    }
}
