package unisa.is.helpseller.Entity;

import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrasportoTest {

    @Test
    public void costruttore(){
        Trasporto t = new Trasporto();
        @SuppressWarnings("deprecation")
		Date data = new Date(2022, 2, 3);
        t.setDataConsegna(data);
        t.setIdOrdine(2);
        t.setIndirizzoConsegna("indirizzo");
        t.setQuantitaMinima(10);
        
        Date d = t.getDataConsegna();
        int id = t.getIdOrdine();
        String i = t.getIndirizzoConsegna();
        int qm = t.getQuantitaMinima();
        
        assertThat(d.toString().isEmpty()).isFalse();
        assertThat(id != 0);
        assertThat(i.isEmpty()).isFalse();
        assertThat(qm != 0 );

    }
}
