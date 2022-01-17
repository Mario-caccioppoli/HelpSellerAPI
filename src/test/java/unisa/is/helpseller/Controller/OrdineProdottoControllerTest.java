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
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import unisa.is.helpseller.Entity.OrdineProdotto;


@SpringBootTest
public class OrdineProdottoControllerTest {

    @Autowired
    private OrdineProdottoController controller;

    @Test
    public void findAll() throws Exception {
    	ResponseEntity<List<OrdineProdotto>> response = controller.findAll();
    	List<OrdineProdotto> all = response.getBody();
    	if(all.size() > 0)
    	{
    		assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	}
    	else
    	{
    		assertThat(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
    	}
    	 assertNotNull(response,"Response is not null");
   }
    
    @Test
    public void findId() throws Exception {
    	ResponseEntity<OrdineProdotto> response = controller.findId(-1, 1);
    	OrdineProdotto single = response.getBody();
    	if(single != null)
    	{
    		assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	}
    	else
    	{
    		assertThat(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
    	}
    	 assertNotNull(response,"Response is not null");
   }
    
}
