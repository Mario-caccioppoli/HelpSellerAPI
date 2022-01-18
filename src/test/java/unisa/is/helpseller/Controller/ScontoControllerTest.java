/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

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

import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Model.ScontoModel;

import java.sql.Date;


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
    	ResponseEntity<ScontoModel> response = controller.findId(1);
    	ScontoModel sconto = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(sconto).isNotNull();
    	assertThat(sconto.getDataInizio().before(sconto.getDataFine())).isTrue();
   }
    
    @Test
    public void CUD() throws Exception {
    	ScontoModel sconto = new ScontoModel(0,50,Date.valueOf("2022-01-10"), Date.valueOf("2022-01-01"),"catalogo", null, 1, new ArrayList<ProdottoModel>());
    	ResponseEntity<ScontoModel> response = controller.insert(sconto);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	/*sconto.setPercentuale(30);
    	response = controller.update(sconto);
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	response = controller.deleteId(sconto.getId());
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));*/
   }
}
