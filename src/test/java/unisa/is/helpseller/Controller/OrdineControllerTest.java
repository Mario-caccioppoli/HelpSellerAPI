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
import unisa.is.helpseller.Model.OrdineModel;


@SpringBootTest
public class OrdineControllerTest {

    @Autowired
    private OrdineController controller;

    @Test
    public void findAllStatus() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findAll();
        List<OrdineModel> allOrdini = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allOrdini).asList();
    }

    @Test
    public void findIncorrectId() throws Exception {
        ResponseEntity<OrdineModel> response = controller.findId(-1);
        OrdineModel ordine = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(ordine).isNull();
    }

    @Test
    public void findCorrectId() throws Exception {
        ResponseEntity<OrdineModel> response = controller.findId(1);
        OrdineModel ordine = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(ordine).isNotNull();
        assertThat(ordine.getDataConsegna().after(ordine.getDataOrdinazione())).isTrue();
    }
    
    @Test
    public void CUD() throws Exception {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 11);
        c1.set(Calendar.DATE, 01);
        c1.set(Calendar.YEAR, 2022);
        java.util.Date d1 = c1.getTime();
        java.sql.Date sqlD1 = new java.sql.Date(d1.getTime());
        
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.MONTH, 23);
        c2.set(Calendar.DATE, 01);
        c2.set(Calendar.YEAR, 2022);
        java.util.Date d2 = c2.getTime();
        java.sql.Date sqlD2 = new java.sql.Date(d2.getTime());
  //Date dataOrdinazione, Date dataConsegna, String commento, String stato, int idDistributore, DocumentoModel documento, double prezzoTotale
        OrdineModel ordine = new OrdineModel(sqlD1, sqlD2, "", "", 1, null, 120);
    	ResponseEntity<OrdineModel> response = controller.insert(ordine);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	ordine.setStato("consegnato");
    	response = controller.update(ordine);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	response = controller.deleteId(ordine.getId());
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
    
    @Test
    public void ricercaPerDistributore() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByDistributore(1);
        OrdineModel ordine = response.getBody().get(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(ordine).isNotNull();
        assertThat(ordine.getDataConsegna().after(ordine.getDataOrdinazione())).isTrue();
    }
    
    @Test
    public void InvalidRicercaPerDistributore() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByDistributore(150);
        OrdineModel ordine = response.getBody().get(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }
    
    @Test
    public void RicercaPerAzienda() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByAzienda(1);
        OrdineModel ordine = response.getBody().get(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(ordine).isNotNull();
        assertThat(ordine.getDataConsegna().after(ordine.getDataOrdinazione())).isTrue();
    }
    
    @Test
    public void invalidRicercaPerAzienda() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByAzienda(15);
        OrdineModel ordine = response.getBody().get(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }
}