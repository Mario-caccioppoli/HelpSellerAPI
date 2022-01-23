package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DocumentoTest {

    @Test
    public void costruttore(){
        Documento doc = new Documento();
        Date data = new Date(2022, 2, 3);
        doc.setAutore("aut");
        doc.setData(data);
        doc.setIdOrdine(2);
        doc.setTitolo("tit");

        String aut = doc.getAutore();
        Date data2 = doc.getData();
        int id  = doc.getId();
        String titolo = doc.getTitolo();
        
        assertThat(aut.isEmpty()).isFalse();
        assertThat(data2.equals(null)).isFalse();
        assertThat(id != 0);
        assertThat(titolo.isEmpty()).isFalse();

        Documento d = new Documento("", "", null, 1);

    }
}
