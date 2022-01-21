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
import unisa.is.helpseller.Model.DistributoreModel;
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
        assertThat(distributore).isNull();
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
    public void CreateDestroyFail() throws Exception {
        OrdineModel ordine = new OrdineModel(Date.valueOf("2022-01-10"), Date.valueOf("2022-01-21"), "commentoTest",
                "statoTest", 1, null, 120, null);
        ResponseEntity<Integer> response = controller.insert(ordine);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    public void update() throws Exception{
        ResponseEntity<OrdineModel> response = controller.findId(1);
        OrdineModel d = response.getBody();
        d.setCommento("commento modificato dal test");
        ResponseEntity<Integer> response2 = controller.update(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void invalidUpdate() throws Exception{
        ResponseEntity<OrdineModel> response = controller.findId(1);
        OrdineModel d = response.getBody();
        d.setDataConsegna(null);
        ResponseEntity<Integer> response2 = controller.update(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
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
    public void invalidDelete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(-1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody()).isNull();
    }

    @Test
    public void invalidDelete2() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(999);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response.getBody()).isNull();
    }

    @Test
    public void delete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody()).isNull();
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
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }
}