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
import unisa.is.helpseller.Model.AziendaModel;
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
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(distributore).isNull();
    }

    @Test
    public void findIncorrectId2() throws Exception {
        ResponseEntity<DistributoreModel> response = controller.findId(55);
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

    @Test
    public void CreateDestroy() throws Exception {
        DistributoreModel distributore = new DistributoreModel("Gaetano", "gaetano@email.it", "123", "Gaetano",
                "Frizzi", "777", "389", "via della sede", null, null);
        ResponseEntity<Integer> response = controller.insert(distributore);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);

        ResponseEntity<Integer> response2 = controller.deleteId(response.getBody());
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void update() throws Exception{
        ResponseEntity<DistributoreModel> response = controller.findId(1);
        DistributoreModel d = response.getBody();
        d.setCognome("de gregorio");
        System.out.println(d.getId() + d.getNome() + d.getEmail() + " model");
        ResponseEntity<Integer> response2 = controller.update(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void invalidUpdate() throws Exception{
        ResponseEntity<DistributoreModel> response = controller.findId(9);
        DistributoreModel d = response.getBody();
        d.setVat("125425");
        ResponseEntity<Integer> response2 = controller.update(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
    }

    @Test
    public void invalidInsert() throws Exception{
        DistributoreModel distributore = new DistributoreModel("Gaetano", "gaetano@email.it", "123", "Gaetano",
                "Frizzi", "1", "389", "via della sede", null, null);
        ResponseEntity<Integer> response2 = controller.insert(distributore);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response2.getBody()).isNull();
    }

    @Test
    public void invalidDelete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(-1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody()).isEqualTo(0);
    }

    @Test
    public void invalidDelete2() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(999);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response.getBody()).isEqualTo(0);
    }
}