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
import java.util.Calendar;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.DocumentoModel;
import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Model.ScontoModel;

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
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(data);
        assertThat(documento.getData().before(data));
    }

    //int id, String titolo, String autore, Date data, int idOrdine
    public void CUD() throws Exception {
        DocumentoModel documento = new DocumentoModel(0, "DocumentoTest", "aldo moro", Date.valueOf("2022-01-10"), 1);

        ResponseEntity<Integer> response = controller.insert(documento);

        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));

        documento.setTitolo("nuovo titolo");

        response = controller.update(documento);

        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        
        assertThat(response.getBody() > 0);

        response = controller.deleteId(documento.getId());

        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        
        assertThat(response.getBody() > 0);
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
