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
import unisa.is.helpseller.Model.TrasportoModel;


@SpringBootTest
public class TrasportoControllerTest {

    @Autowired
    private TrasportoController controller;

    @Test
    public void findAllStatus() throws Exception {
    	ResponseEntity<List<TrasportoModel>> response = controller.findAll();
    	List<TrasportoModel> allTrasporti = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(allTrasporti).asList();
   }
  
    @Test
    public void findIncorrectId() throws Exception {
    	ResponseEntity<TrasportoModel> response = controller.findId(-1);
    	TrasportoModel trasporto = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    	assertThat(trasporto).isNull();
   }
    @Test
    public void findCorrectId() throws Exception {
    	ResponseEntity<TrasportoModel> response = controller.findId(1);
    	TrasportoModel trasporto = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(trasporto).isNotNull();
   }

    //int id, String indirizzoConsegna, int quantitaMinima, Date dataConsegna, int idOrdine
    @Test
    public void Crea() throws Exception {
        TrasportoModel trasporto = new TrasportoModel(0, "indirizzoconsegnaTest", 1, Date.valueOf("2022-01-10"), 1);
        ResponseEntity<Integer> response = controller.insert(trasporto);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() == null);
    }

    @Test
    public void CreaInvalid() throws Exception {
        TrasportoModel trasporto = new TrasportoModel(0, "indirizzoconsegnaTest", 1, null, 1);
        ResponseEntity<Integer> response = controller.insert(trasporto);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() == null);
    }
/*
    @Test
    public void delete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(2);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
    }
*/


    @Test
    public void deleteInvalid() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(160);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() == null);
    }

    @Test
    public void deleteInvalid2() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(-1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() == null);
    }

    @Test
    public void update() throws Exception {
        TrasportoModel t = controller.findId(1).getBody();
        t.setIndirizzoConsegna("nuovo indirizzo");
        ResponseEntity<Integer> response = controller.update(t);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
    }

    @Test
    public void invalidUpdate() throws Exception {
        TrasportoModel t = controller.findId(1).getBody();
        t.setDataConsegna(null);
        ResponseEntity<Integer> response = controller.update(t);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() == null);
    }
}
