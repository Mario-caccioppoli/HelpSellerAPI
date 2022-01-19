/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Controller;

/**
 *
 * @author UTENTE
 */
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.DistributoreModel;


@SpringBootTest
public class DistributoreControllerTest {

    @Autowired
    private DistributoreController controller;

    @Test
    public void findAllStatus() throws Exception {
        ResponseEntity<List<DistributoreModel>> response = controller.findAll();
        List<DistributoreModel> allDistributori = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allDistributori).asList();
    }

    @Test
    public void findIncorrectId() throws Exception {
        ResponseEntity<DistributoreModel> response = controller.findId(-1);
        DistributoreModel distributore = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(distributore).isNull();
    }

    @Test
    public void findCorrectId() throws Exception {
        ResponseEntity<DistributoreModel> response = controller.findId(1);
        DistributoreModel distributore = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(distributore).isNotNull();
    }
    
    //public DistributoreModel(String username, String email, String password, String nome, String cognome, String vat, 
    //String telefono, String indirizzoSede, Integer idOrdineProva, List<OrdineModel> ordini)
    @Test
    public void CUD() throws Exception {
        DistributoreModel distributore = new DistributoreModel("prova", "fabio@email.it", "123", "Fabio", "Frizzi", "1", "333", "via della sede", null, null);
        ResponseEntity<Integer> response = controller.insert(distributore);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
        String email = "fabio22@email.it";
        distributore.setEmail(email);
        response = controller.update(distributore);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        response = controller.deleteId(distributore.getId());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
}