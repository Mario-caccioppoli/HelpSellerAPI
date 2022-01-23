package unisa.is.helpseller.Entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistributoreTest {

    @Test
    public void costruttore(){
        Distributore dist = new Distributore();
        dist.setEmail("mail");
        dist.setPassword("pass");
        dist.setUsername("username");
        dist.setNome("nome");
        dist.setCognome("cognome");
        dist.setvat("11111");
        dist.setTelefono("191919");
        dist.setIndirizzoSede("viaiviav");
        String mail = dist.getEmail();
        String pass = dist.getPassword();
        String user = dist.getUsername();
        String nome = dist.getNome();
        String cognome = dist.getCognome();
        String vat = dist.getvat();
        String tel = dist.getTelefono();
        String sede = dist.getIndirizzoSede();
        assertThat(mail.isEmpty()).isFalse();
        assertThat(pass.isEmpty()).isFalse();
        assertThat(user.isEmpty()).isFalse();
        assertThat(nome.isEmpty()).isFalse();
        assertThat(cognome.isEmpty()).isFalse();
        assertThat(vat.isEmpty()).isFalse();
        assertThat(tel.isEmpty()).isFalse();
        assertThat(sede.isEmpty()).isFalse();

        Distributore d = new Distributore("", "", "", "", "", "", "", "", 1);
        d.setIdOrdineProva(2);
    }
}
