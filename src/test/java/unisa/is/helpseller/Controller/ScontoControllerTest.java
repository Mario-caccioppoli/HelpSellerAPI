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
import unisa.is.helpseller.Model.ScontoModel;
import java.util.Calendar;


@SpringBootTest
public class ScontoControllerTest {

    @Autowired
    private ScontoController controller;

    @Test
    public void findAllStatus() throws Exception {
    	ResponseEntity<List<ScontoModel>> response = controller.findAll();
    	List<ScontoModel> allSconti = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(allSconti).asList();
   }
  
    @Test
    public void findIncorrectId() throws Exception {
    	ResponseEntity<ScontoModel> response = controller.findId(-1);
    	ScontoModel sconto = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    	assertThat(sconto).isNull();
   }
    @Test
    public void findCorrectId() throws Exception {
    	ResponseEntity<ScontoModel> response = controller.findId(4);
    	ScontoModel sconto = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(sconto).isNotNull();
    	assertThat(sconto.getDataInizio().before(sconto.getDataFine())).isTrue();
   }
//test Create Update Delete POSITIVO
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
  
        ScontoModel sconto = new ScontoModel(1, "newSconto", 10, sqlD1, sqlD2, "catalogo", 5, 1);
    	ResponseEntity<ScontoModel> response = controller.insert(sconto);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	sconto.setPercentuale(30);
    	response = controller.update(sconto);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	response = controller.deleteId(sconto.getId());
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
    
//test Create Update Delete negativo
    @Test
    public void CUDfail() throws Exception {
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
  
        ScontoModel sconto = new ScontoModel(1, "newSconto", 10, sqlD1, sqlD2, "catalogo", 5, 1);
    	ResponseEntity<ScontoModel> response = controller.insert(sconto);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	sconto.setPercentuale(-5);
    	response = controller.update(sconto);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
    	response = controller.deleteId(sconto.getId());
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
}



//vedo lo status find all return tutti oggetti o array vuoto, controlo sollo status e che sia una lista, non mi ritorni null
////@Test nomemetodo 
//prima lo inserisco controllo status, dopo lo modifico controllo status ok e poi delete controllo status delete