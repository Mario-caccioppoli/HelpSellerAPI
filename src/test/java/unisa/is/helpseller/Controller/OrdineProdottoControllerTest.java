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

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.OrdineProdottoModel;
import unisa.is.helpseller.Model.ProdottoModel;


@SpringBootTest
public class OrdineProdottoControllerTest {

    @Autowired
    private OrdineProdottoController controller;

    @Autowired
    private ProdottoController pc;

    //int idOrdine, int quantitaOrdine, double prezzoUnitario, ProdottoModel prodotto
    @Test
    public void invalidInsert() throws Exception {
        OrdineProdottoModel opm = new OrdineProdottoModel(1, 1, 1, null);
        List<OrdineProdottoModel> list = new ArrayList<>();
        list.add(opm);
        ResponseEntity<List<Integer>> response = controller.insert(list);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void insert() throws Exception {
        ProdottoModel p = pc.findId(1).getBody();
        OrdineProdottoModel opm = new OrdineProdottoModel(12, 1, 1, p);
        List<OrdineProdottoModel> list = new ArrayList<>();
        list.add(opm);
        ResponseEntity<List<Integer>> response = controller.insert(list);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
/*
    @Test
    public void delete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(1, 1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
*/
    @Test
    public void invalidDelete() throws Exception {
        ResponseEntity<Integer> response = controller.deleteId(15, 15);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_MODIFIED));
    }

    @Test
    public void update() throws Exception {
        OrdineProdottoModel opm = controller.findDettagliOrdine(2).getBody().get(0);
        opm.setPrezzoUnitario(5);
        ResponseEntity<Integer> response = controller.update(opm);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void updateInvalid() throws Exception {
        OrdineProdottoModel opm = controller.findDettagliOrdine(2).getBody().get(0);
        opm.setProdotto(null);
        ResponseEntity<Integer> response = controller.update(opm);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void invalidCerca() throws Exception {
        ResponseEntity<List<OrdineProdottoModel>> response = controller.findDettagliOrdine(1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void findDettagliOrdineFail() throws Exception {
        ResponseEntity<List<OrdineProdottoModel>> response = controller.findDettagliOrdine(99);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void findReportAnno() throws Exception {
        ResponseEntity<ArrayList<ArrayList<Integer>>> response = controller.findReportAnnuale();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }


    @Test
    public void findReportMensile() throws Exception {
        ResponseEntity<Integer[]> response = controller.findReportMensile(2022, 1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void findReportMensileFail() throws Exception {
        ResponseEntity<Integer[]> response = controller.findReportMensile(2022, 125);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void findReportMensileFail2() throws Exception {
        ResponseEntity<Integer[]> response = controller.findReportMensile(-1, 125);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void findReportMensileGruppo() throws Exception {
        ResponseEntity<Integer[]> response = controller.findReportMensileGruppo(2022);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void findReportMensileGruppoFail() throws Exception {
        ResponseEntity<Integer[]> response = controller.findReportMensileGruppo(-1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void findReportAnnualeAzienda() throws Exception {
        ResponseEntity<ArrayList<ArrayList<Integer>>> response = controller.findReportAnnualeAzienda(1);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }

    @Test
    public void findReportAnnualeAziendaFail() throws Exception {
        ResponseEntity<ArrayList<ArrayList<Integer>>> response = controller.findReportAnnualeAzienda(999);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
}
