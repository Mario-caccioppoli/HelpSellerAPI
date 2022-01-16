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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Entity.Sconto;


@SpringBootTest
public class ScontoControllerTest {

    @Autowired
    private ScontoController controller;
    ResponseEntity<Sconto> response;
    private Sconto sconto;
    
    @BeforeEach
    public void setUp() {
    	response = controller.findId(1);
    	sconto = response.getBody();
    }

    @Test
    public void findAllStatus() throws Exception {
    	ResponseEntity<List<Sconto>> response = controller.findAll();
    	List<Sconto> allSconti = response.getBody();
    	if(allSconti.size() > 0)
    	{
    		assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	}
    	else
    	{
    		assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    	}
   }
  
    @Test
    public void Status() throws Exception {
    	if(sconto != null)
    	{
    		assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	}
    	else
    	{
    		assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    	}
   }
    
    @Test
    public void Id() throws Exception {
    	if(sconto != null)
    	{
    		assertThat(sconto.getId() > 0);
    	}
   }
}
