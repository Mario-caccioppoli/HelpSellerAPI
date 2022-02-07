package unisa.is.helpseller.Controller;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.ScontoProdottoModel;
import unisa.is.helpseller.Model.UtenteModel;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UtenteControllerTest {

    @Autowired
    private UtenteController controller;

    @Test
    public void loginAzienda() throws Exception {
        String tipo = "Azienda";
        String email = "bevande@gmail.com";
        String password = "123";
        
        ResponseEntity<UtenteModel> response = controller.auth(tipo, email, password);
        UtenteModel utente = response.getBody();
        assertThat(utente.getTipo().contains("Azienda"));
        assertThat(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void loginDistributore() throws Exception {
        String tipo = "Distributore";
        String email = "fabio@email.it";
        String password = "123";
        
        ResponseEntity<UtenteModel> response = controller.auth(tipo, email, password);
        UtenteModel utente = response.getBody();
        assertThat(utente.getTipo().contains("Distributore"));
        assertThat(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void loginAmministratore() throws Exception {
        String tipo = "Amministratore";
        String email = "aldo@libeo.it";
        String password = "password";
        
        ResponseEntity<UtenteModel> response = controller.auth(tipo, email, password);
        UtenteModel utente = response.getBody();
        assertThat(utente.getTipo().contains("Amministratore"));
        assertThat(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void recuperoPassword() throws Exception {
        String email = "bevande@gmail.com";
        ResponseEntity<Integer> response = controller.recuperoPassword(email);
        
        Integer result = response.getBody();
        assertThat(result.intValue() == 1);
    }

    @Test
    public void recuperoPasswordFail() throws Exception {
        String email = "bevanasdsadde@gmail.com";
        ResponseEntity<Integer> response = controller.recuperoPassword(email);

        Integer result = response.getBody();
        assertThat(result.intValue() == 1);
    }

    @Test
    public void recuperoPasswordFail2() throws Exception {
        String email = "";
        ResponseEntity<Integer> response = controller.recuperoPassword(email);

        Integer result = response.getBody();
        assertThat(result.intValue() == 1);
    }
    
    @Test
    public void wrongLogin() throws Exception {
        String tipo = "Azienda";
        String email = "bevande@gmail.com";
        String password = "12332322";
        
        ResponseEntity<UtenteModel> response = controller.auth(tipo, email, password);
        assertThat(response.getStatusCode().is5xxServerError());
    }

    @Test
    public void wrongLogin2() throws Exception {
        String tipo = "Amministratore";
        String email = "bevanddve@gmailasd.com";
        String password = "12332322";

        ResponseEntity<UtenteModel> response = controller.auth(tipo, email, password);
        assertThat(response.getStatusCode().is5xxServerError());
    }

    @Test
    public void loginDistributoreFail() throws Exception {
        String tipo = "Distributore";
        String email = "fabiowsdfswdw@email.it";
        String password = "12332532";

        ResponseEntity<UtenteModel> response = controller.auth(tipo, email, password);
        assertThat(response.getStatusCode().is5xxServerError());
    }

    @Test
    public void costr() throws Exception {
        UtenteModel u = new UtenteModel("a", "b", "c", "d");
        u.setCognome("c");u.setDescrizione("d");u.setEmail("");u.setIndirizzo("");u.setLogo("");u.setPassword("");
        u.setNome("");u.setTelefono("");u.setUsername("");u.setVat("");
        u.getCognome();u.getDescrizione();u.getEmail();u.getIndirizzo();u.getLogo();u.getPassword();
        u.getNome();u.getTelefono();u.getUsername();u.getVat();
    }
}
