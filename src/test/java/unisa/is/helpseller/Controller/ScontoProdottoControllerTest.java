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
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.ScontoProdottoModel;

@SpringBootTest
public class ScontoProdottoControllerTest {

    @Autowired
    private ScontoProdottoController controller;

    @Test
    public void findAllStatus() throws Exception {
        ResponseEntity<List<ScontoProdottoModel>> response = controller.findAllScontoProdotto();
        List<ScontoProdottoModel> allSconti = response.getBody();
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(allSconti).asList();
    }
    
    @Test
    public void CD() throws Exception {
        ResponseEntity<Integer> response = controller.insert(5, 4);
        System.out.println("id value : " + response.getBody());
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response.getBody() > 0);

        ResponseEntity<Integer> response2 = controller.deleteId(4);
        assertThat(response2.getStatusCode().compareTo(HttpStatus.OK));
        assertThat(response2.getBody() > 0);
    }
}
