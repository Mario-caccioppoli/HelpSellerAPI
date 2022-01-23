package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        
  
    }
}
