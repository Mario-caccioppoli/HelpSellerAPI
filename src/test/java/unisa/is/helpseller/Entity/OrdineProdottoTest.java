package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrdineProdottoTest {

    @Test
    public void costruttore(){
        OrdineProdotto op = new OrdineProdotto();
        Date data = new Date(2022, 2, 3);
        op.setIdOrdine(1);
        op.setIdProdotto(1);
        op.setPrezzo(100);
        op.setPrezzoUnitario(2);
        op.setQuantitaOrdine(50);

        int io = op.getIdOrdine();
        int ip = op.getIdProdotto();
        double p = op.getPrezzo();
        double pu = op.getPrezzoUnitario();
        int q = op.getQuantitaOrdine();
        
        assertThat(io != 0);
        assertThat(ip != 0);
        assertThat(p != 0);
        assertThat(pu != 0);
        assertThat(q != 0);

    }
}
