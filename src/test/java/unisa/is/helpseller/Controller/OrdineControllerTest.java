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
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(ordine).isNull();
    }

    @Test
    public void findIncorrectId2() throws Exception {
        ResponseEntity<OrdineModel> response = controller.findId(55);
        OrdineModel distributore = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(distributore).isNotNull();
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
    public void createFail() throws Exception {
        OrdineModel ordine = new OrdineModel(Date.valueOf("2022-01-10"), Date.valueOf("2022-01-21"), "commentoTest",
                "statoTest", 1, null, null, 120, null, null);
        ResponseEntity<Integer> response = controller.insert(ordine);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    public void invalidInsert() throws Exception{
        ResponseEntity<OrdineModel> response = controller.findId(1);
        OrdineModel d = response.getBody();
        d.setIdDistributore(155);
        ResponseEntity<Integer> response2 = controller.insert(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response2.getBody()).isNull();

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
    public void invalidRicercaPerDistributore() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByDistributore(150);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }
    
    @Test
    public void ricercaPerAzienda() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByAzienda(1);
        OrdineModel ordine = response.getBody().get(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(ordine).isNotNull();
        assertThat(ordine.getDataConsegna().after(ordine.getDataOrdinazione())).isTrue();
    }
    
    @Test
    public void invalidRicercaPerAzienda() throws Exception {
        ResponseEntity<List<OrdineModel>> response = controller.findOrdiniByAzienda(15);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }
}