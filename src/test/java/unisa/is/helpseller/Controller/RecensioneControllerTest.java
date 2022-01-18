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
import java.util.Calendar;
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
    public void findCorrectId() throws Exception {
    	ResponseEntity<RecensioneModel> response = controller.findId(1);
    	RecensioneModel recensione = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(recensione).isNotNull();
   }
    //String testo, int voto, Date data, int idProdotto, int idDistributore
    @Test
    public void CUD() throws Exception {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 01);
        c1.set(Calendar.DATE, 23);
        c1.set(Calendar.YEAR, 2022);
        java.util.Date d1 = c1.getTime();
        java.sql.Date data = new java.sql.Date(d1.getTime());
        
        RecensioneModel recensione = new RecensioneModel("testo recensione", 3, data, 4, 1);
        ResponseEntity<RecensioneModel> response = controller.insert(recensione);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        String email = "azienda@email.it";
        recensione.setTesto("nuovo testo recensione");
        response = controller.update(recensione);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        response = controller.deleteId(recensione.getId());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
}
