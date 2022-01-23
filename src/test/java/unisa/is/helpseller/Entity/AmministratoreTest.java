package unisa.is.helpseller.Entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AmministratoreTest {

    @Test
    public void costruttore(){
        Amministratore admin = new Amministratore();
        admin.setEmail("mail");
        admin.setPassword("pass");
        admin.setUsername("username");
        String mail = admin.getEmail();
        String pass = admin.getPassword();
        String user = admin.getUsername();
        assertThat(mail.isEmpty()).isFalse();
        assertThat(pass.isEmpty()).isFalse();
        assertThat(user.isEmpty()).isFalse();
    }
}
