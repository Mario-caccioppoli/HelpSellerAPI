package unisa.is.helpseller.Controller;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.AziendaModel;

@SpringBootTest
public class AziendaControllerTest {

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

    //public AziendaModel(String email, String password, String nomeAzienda, String vat, String indirizzo, 
    //String descrizione, String logo, List<ProdottoModel> prodotti, List<OrdineModel> ordini)
    
    @Test
    public void CUD() throws Exception {
        AziendaModel azienda = new AziendaModel("", "123", "AziendaTest", "123", "via vai", "azienda di prova", "", null, null);
        ResponseEntity<Integer> response = controller.insert(azienda);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);
        String email = "azienda@email.it";
        azienda.setEmail(email);
        response = controller.update(azienda);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        response = controller.deleteId(azienda.getId());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    }
    
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
