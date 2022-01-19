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
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(data);
        assertThat(documento.getData().before(data));
    }

    //int id, String titolo, String autore, Date data, int idOrdine
    @Test
    public void CUD() throws Exception {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 15);
        c1.set(Calendar.DATE, 01);
        c1.set(Calendar.YEAR, 2022);
        java.util.Date d1 = c1.getTime();
        java.sql.Date data = new java.sql.Date(d1.getTime());

        DocumentoModel documento = new DocumentoModel(150, "doc del test", "aldo moro", data, 1);
        ResponseEntity<Integer> response = controller.insert(documento);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
        String email = "azienda@email.it";
        documento.setTitolo("nuovo titolo");
        response = controller.update(documento);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        response = controller.deleteId(documento.getId());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
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
