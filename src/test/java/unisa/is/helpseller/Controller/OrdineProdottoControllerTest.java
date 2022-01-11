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
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


@SpringBootTest
public class OrdineProdottoControllerTest {

    @Autowired
    private OrdineProdottoController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId(1).getBody().getClass().equals("OrdineProdotto"));
    assertThat(controller.findId(1).getBody().getQuantita()>0);
    assertThat(controller.findId(1).getBody().getIdProdotto()>0);
    assertThat(controller.findId(1).getBody().getPrezzoUnitario()>0);
    }
}
