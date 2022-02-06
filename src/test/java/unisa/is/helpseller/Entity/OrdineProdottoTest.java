package unisa.is.helpseller.Entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrdineProdottoTest {

    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void costruttore(){
        OrdineProdotto op = new OrdineProdotto();
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

        OrdineProdottoId op2 = new OrdineProdottoId(1, 1);
        op2.hashCode();
        op2.getId_ordine();
        op2.getId_prodotto();
        op2.setId_ordine(1);
        op2.setId_prodotto(1);
        op2.equals(op);

    }
}
