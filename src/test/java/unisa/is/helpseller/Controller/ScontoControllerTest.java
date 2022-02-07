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
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.ScontoModel;
import unisa.is.helpseller.Model.ProdottoModel;


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
    	assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
    	assertThat(sconto).isNull();
   }

    @Test
    public void findIncorrectId2() throws Exception {
        ResponseEntity<ScontoModel> response = controller.findId(609);
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
    
    //(int id, String nomeSconto, int percentuale, Date dataInizio, Date dataFine, String tipo, Integer quantita, 
            //int idAzienda, List<ProdottoModel> prodotti) {
    @Test
    public void CreateDestroy() throws Exception {
        ScontoModel sconto = new ScontoModel(0, "ScontoTest", 50, Date.valueOf("2022-01-10"), Date.valueOf("2022-01-01"),
                "catalogo", null, 1, new ArrayList<ProdottoModel>());
        ResponseEntity<Integer> response = controller.insert(sconto);
        System.out.println("id value : " + response.getBody());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);

        ResponseEntity<Integer> response2 = controller.deleteId(response.getBody());
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void InvalidInsert() throws Exception {
        ScontoModel sconto = new ScontoModel(0, "ScontoTest", 50, Date.valueOf("2022-01-10"), Date.valueOf("2022-01-01"),
                "catalogo", null, 170, new ArrayList<ProdottoModel>());
        ResponseEntity<Integer> response = controller.insert(sconto);
        System.out.println("id value : " + response.getBody());
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody() == null);
    }

    @Test
    public void invalidDelete() throws Exception{
        ResponseEntity<Integer> response = controller.deleteId(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody() == null);
    }

    @Test
    public void update() throws Exception{
        ResponseEntity<ScontoModel> response = controller.findId(4);
        ScontoModel sconto = response.getBody();
        sconto.setPercentuale(4);
        ResponseEntity<Integer> response2 = controller.update(sconto);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void updateInvalid() throws Exception{
        ResponseEntity<ScontoModel> response = controller.findId(4);
        ScontoModel sconto = response.getBody();
        sconto.setIdAzienda(77);
        ResponseEntity<Integer> response2 = controller.update(sconto);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_MODIFIED));
        assertThat(response2.getBody() == null);
    }

    @Test
    public void findScontiByAzienda() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiByAzienda(1);
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allSconti).asList();
    }

    @Test
    public void invalidFindScontiByAzienda() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiByAzienda(10);
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(allSconti).asList();
    }

    @Test
    public void findScontiByTipo() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiByTipo("catalogo");
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allSconti).asList();
    }

    @Test
    public void invalidFindScontiByTipo() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiByTipo("cose");
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(allSconti).asList();
    }

    @Test
    public void findScontiAziendaByTipo() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiAziendaByTipo("catalogo", 1);
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allSconti).asList();
    }

    @Test
    public void invalidFindScontiAziendaByTipo() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiAziendaByTipo("catalogo", 10);
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(allSconti).asList();
    }

    @Test
    public void findScontiByNomeInAzienda() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiByNomeInAzienda("nome1", 3);
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allSconti).asList();
    }

    @Test
    public void invalidFindScontiByNomeInAzienda() throws Exception {
        ResponseEntity<List<ScontoModel>> response = controller.findScontiByNomeInAzienda("nome999", 3);
        List<ScontoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(allSconti).asList();
    }
}



//vedo lo status find all return tutti oggetti o array vuoto, controlo sollo status e che sia una lista, non mi ritorni null
////@Test nomemetodo 
//prima lo inserisco controllo status, dopo lo modifico controllo status ok e poi delete controllo status delete