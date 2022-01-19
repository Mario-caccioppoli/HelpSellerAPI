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
    
    @Test
    public void CUD() throws Exception {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 01);
        c1.set(Calendar.DATE, 23);
        c1.set(Calendar.YEAR, 2022);
        java.util.Date d1 = c1.getTime();
        java.sql.Date data = new java.sql.Date(d1.getTime());
        //int id, String indirizzoConsegna, int quantitaMinima, Date dataConsegna, int idOrdine
        TrasportoModel trasporto = new TrasportoModel(15, "via vai", 1, data, 1);
        ResponseEntity<Integer> response = controller.insert(trasporto);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
        trasporto.setIndirizzoConsegna("nuovo indirizzo");
        response = controller.update(trasporto);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        response = controller.deleteId(trasporto.getId());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
}
