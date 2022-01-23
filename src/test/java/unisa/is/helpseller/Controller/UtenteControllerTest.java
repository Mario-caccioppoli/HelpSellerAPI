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

    public static JSONObject azienda() throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("tipo", "Azienda");
        sampleObject.put("email", "bevande@gmail.com");
        sampleObject.put("password", "123");
        return sampleObject;
    }

    public static JSONObject distributore() throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("tipo", "Distributore");
        sampleObject.put("email", "fabio@email.it");
        sampleObject.put("password", "123");
        return sampleObject;
    }

    public static JSONObject admin() throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("tipo", "Amministratore");
        sampleObject.put("email", "aldo@libeo.it");
        sampleObject.put("password", "password");
        return sampleObject;
    }

    @Test
    public void loginAzienda() throws Exception {
        JSONObject json = azienda();
        String input = json.toString();

        ResponseEntity<UtenteModel> response = controller.auth(input);
        UtenteModel utente = response.getBody();
        assertThat(utente.getTipo().contains("Azienda"));
        assertThat(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void loginDistributore() throws Exception {
        JSONObject json = distributore();
        String input = json.toString();

        ResponseEntity<UtenteModel> response = controller.auth(input);
        UtenteModel utente = response.getBody();
        assertThat(utente.getTipo().contains("Distributore"));
        assertThat(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void loginAmministratore() throws Exception {
        JSONObject json = admin();
        String input = json.toString();

        ResponseEntity<UtenteModel> response = controller.auth(input);
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
    public void wrongLogin() throws Exception {
        JSONObject json = new JSONObject();
        json.put("tipo", "Distributore");
        json.put("email", "fabio@email.it");
        json.put("password", "wrooong");
        String input = json.toString();
        ResponseEntity<UtenteModel> response = controller.auth(input);
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
