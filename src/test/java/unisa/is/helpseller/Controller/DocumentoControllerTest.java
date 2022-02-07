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
import unisa.is.helpseller.Model.DocumentoModel;

@SpringBootTest
public class DocumentoControllerTest {

    @Autowired
    private DocumentoController controller;

    @Test
    public void findAllStatus() throws Exception {
        ResponseEntity<List<DocumentoModel>> response = controller.findAll();
        List<DocumentoModel> allDocumenti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allDocumenti).asList();
    }

    @Test
    public void findIncorrectId() throws Exception {
        ResponseEntity<DocumentoModel> response = controller.findId(-1);
        DocumentoModel documento = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(documento).isNull();
    }

    @Test
    public void findCorrectId() throws Exception {
        ResponseEntity<DocumentoModel> response = controller.findId(4);
        DocumentoModel documento = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(documento).isNotNull();

        //controllo che la data del documento sia valida
        java.util.Date data = new java.util.Date();
        assertThat(documento.getData().before(data));
    }

    //int id, String titolo, String autore, Date data, int idOrdine
    @Test
    public void CreateDestroy() throws Exception {
        DocumentoModel documento = new DocumentoModel(0, "DocumentoTest", "aldo moro", Date.valueOf("2022-01-10"), 1);

        ResponseEntity<Integer> response = controller.insert(documento);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);

        ResponseEntity<Integer> response2 = controller.deleteId(response.getBody());
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void update() throws Exception{
        ResponseEntity<DocumentoModel> response = controller.findId(4);
        DocumentoModel d = response.getBody();
        d.setAutore("aldo baglio");
        ResponseEntity<Integer> response2 = controller.update(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void invalidUpdate() throws Exception{
        ResponseEntity<DocumentoModel> response = controller.findId(4);
        DocumentoModel d = response.getBody();
        d.setData(null);
        ResponseEntity<Integer> response2 = controller.update(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
    }

    @Test
    public void invalidInsert() throws Exception{
        ResponseEntity<DocumentoModel> response = controller.findId(4);
        DocumentoModel d = response.getBody();
        ResponseEntity<Integer> response2 = controller.insert(d);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response2.getBody()).isNotNull();
    }

    @Test
    public void invalidDelete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(-1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody() == 0).isTrue();
    }

    @Test
    public void invalidDelete2() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(999);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response.getBody() == 0).isTrue();
    }

    @Test
    public void ricercaPerOrdine() throws Exception{
        ResponseEntity<List<DocumentoModel>> response = controller.findDocumentiByOrdine(1);
        List<DocumentoModel> allDocumenti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allDocumenti).asList();
    }
    
    @Test
    public void invalidRicercaPerOrdine() throws Exception{
        ResponseEntity<List<DocumentoModel>> response = controller.findDocumentiByOrdine(150);
        List<DocumentoModel> allDocumenti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allDocumenti).asList();
    }

}
