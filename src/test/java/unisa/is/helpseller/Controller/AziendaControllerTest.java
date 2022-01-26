package unisa.is.helpseller.Controller;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Model.AziendaModel;
import unisa.is.helpseller.Model.DistributoreModel;

@SpringBootTest
public class AziendaControllerTest {
    public int id;
    @Autowired
    private AziendaController controller;
    
    @Test
    public void findAllStatus() throws Exception {
        ResponseEntity<List<AziendaModel>> response = controller.findAll();
        List<AziendaModel> allAziende = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allAziende).asList();
    }

    @Test
    public void findIncorrectId() throws Exception {
        ResponseEntity<AziendaModel> response = controller.findId(-1);
        AziendaModel azienda = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
        assertThat(azienda).isNull();
    }

    @Test
    public void findCorrectId() throws Exception {
        ResponseEntity<AziendaModel> response = controller.findId(1);
        AziendaModel azienda = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(azienda).isNotNull();
    }

    //String email, String password, String nomeAzienda, String vat, String indirizzo, String descrizione, String logo, List<ProdottoModel> prodotti, List<OrdineModel> ordini
    @Test
    public void CreateDestroy() throws Exception {
        AziendaModel azienda = new AziendaModel("emailAziendaTest@email.it", "password",
                "AziendaTest", "99", "via vai", "azienda di prova", "", null, null);
        ResponseEntity<Integer> response = controller.insert(azienda);
        System.out.println("id value : " + response.getBody());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);

        ResponseEntity<Integer> response2 = controller.deleteId(response.getBody());
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void update() throws Exception{
        ResponseEntity<AziendaModel> response = controller.findId(1);
        AziendaModel azienda = response.getBody();
        azienda.setDescrizione("descrizione modificata dal test");
        ResponseEntity<Integer> response2 = controller.update(azienda);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }

    @Test
    public void invalidUpdate() throws Exception{
        AziendaModel azienda = controller.findId(1).getBody();
        ResponseEntity<Integer> response = controller.update(azienda);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_MODIFIED));
        assertThat(response.getBody() == 0);
        System.out.println("DIO CANE SCHIFOSO ID : " + response.getBody());
    }

    @Test
    public void invalidInsert() throws Exception{
        ResponseEntity<AziendaModel> response = controller.findId(1);
        AziendaModel azienda = response.getBody();
        ResponseEntity<Integer> response2 = controller.insert(azienda);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response2.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response2.getBody() == null);
    }

    @Test
    public void invalidDelete() throws Exception{
        ResponseEntity<Integer> response = controller.deleteId(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_ACCEPTABLE));
        assertThat(response.getBody() == null);
    }

/*
    @Test
    public void insert() throws Exception{
        ResponseEntity<Integer> response = controller.insert(azienda);
        id = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
    }

    @Test
    public void delete() throws Exception{
        System.out.println("VALORE DI ID: " + azienda.getId());
        ResponseEntity<Integer> response = controller.deleteId(azienda.getId());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }*/
    
    @Test
    public void ricercaPerNome() throws Exception{
        String nome = "bevande SPA";
        ResponseEntity<List<AziendaModel>> response = controller.findAziendeByNome(nome);
        AziendaModel azienda = response.getBody().get(0);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(azienda).isNotNull();
    }
    
    @Test
    public void InvalidRicercaPerNome() throws Exception{
        String nome = "un nome generico";
        ResponseEntity<List<AziendaModel>> response = controller.findAziendeByNome(nome);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    }
    
    @Test
    public void ricercaPerProdotto() throws Exception{
        ResponseEntity<AziendaModel> response = controller.findAziendaByProdotto(1);
        AziendaModel azienda = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(azienda).isNotNull();
    }
    
    @Test
    public void InvalidRicercaPerProdotto() throws Exception{
        ResponseEntity<AziendaModel> response = controller.findAziendaByProdotto(55);
        AziendaModel azienda = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(azienda).isNull();
    }

}
