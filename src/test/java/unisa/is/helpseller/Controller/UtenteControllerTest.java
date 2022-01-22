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


    public static JSONObject datiDaccesso() throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("tipo", "azienda");
        sampleObject.put("email", "bevande@gmail.com");
        sampleObject.put("password", "123");
        return sampleObject;
    }

    @Test
    public void login() throws Exception {
       //ResponseEntity<UtenteModel> response = controller.auth("");
        //assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }


}
