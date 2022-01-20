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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Recensione;
import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Model.RecensioneModel;
import unisa.is.helpseller.Model.ScontoModel;


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
    public void findCorrectId() throws Exception {
    	ResponseEntity<RecensioneModel> response = controller.findId(1);
    	RecensioneModel recensione = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(recensione).isNotNull();
   }

    //(String testo, int voto, Date data, int idProdotto, int idDistributore)
    public void CUD() throws Exception {
        RecensioneModel recensione = new RecensioneModel("recensione test", 5, Date.valueOf("2022-01-10"), 1, 1);

        ResponseEntity<Integer> response = controller.insert(recensione);

        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));

        recensione.setVoto(4);

        response = controller.update(recensione);

        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        
        assertThat(response.getBody() > 0);

        response = controller.deleteId(recensione.getId());

        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        
        assertThat(response.getBody() > 0);
    }
}
