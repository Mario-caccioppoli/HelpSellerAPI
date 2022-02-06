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
import java.sql.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.RecensioneModel;


@SpringBootTest
public class RecensioneControllerTest {

    @Autowired
    private RecensioneController controller;

    @Test
    public void findAllStatus() throws Exception {
    	ResponseEntity<List<RecensioneModel>> response = controller.findAll();
    	List<RecensioneModel> allRecensioni = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(allRecensioni).asList();
   }
  
    @Test
    public void findIncorrectId() throws Exception {
    	ResponseEntity<RecensioneModel> response = controller.findId(-1);
    	RecensioneModel recensione = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    	assertThat(recensione).isNull();
   }

    @Test
    public void findIncorrectId2() throws Exception {
        ResponseEntity<RecensioneModel> response = controller.findId(77);
        RecensioneModel recensione = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(recensione).isNull();
    }
    @Test
    public void findCorrectId() throws Exception {
    	ResponseEntity<RecensioneModel> response = controller.findId(1);
    	RecensioneModel recensione = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(recensione).isNotNull();
   }

    @Test
    public void CreateDestroy() throws Exception {
        RecensioneModel recensione = new RecensioneModel("recensione test", 5, Date.valueOf("2022-01-10"),
                1, 1);
        ResponseEntity<Integer> response = controller.insert(recensione);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);

        ResponseEntity<Integer> response2 = controller.deleteId(response.getBody());
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void insertFail() throws Exception {
        RecensioneModel recensione = new RecensioneModel("recensione test fail", 5, null,
                16, 160);
        ResponseEntity<Integer> response = controller.insert(recensione);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody() == null);
    }

    @Test
    public void deleteFail() throws Exception {
        ResponseEntity<Integer> response2 = controller.deleteId(46);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_MODIFIED));
    }

    @Test
    public void update() throws Exception {
        RecensioneModel r = controller.findId(1).getBody();
        r.setVoto(3);
        ResponseEntity<Integer> response2 = controller.update(r);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void updateFail() throws Exception {
        RecensioneModel r = controller.findId(1).getBody();
        r.setIdProdotto(50505);
        ResponseEntity<Integer> response2 = controller.update(r);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }
}
