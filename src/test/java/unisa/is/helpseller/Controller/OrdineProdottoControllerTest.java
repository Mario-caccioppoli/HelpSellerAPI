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

import unisa.is.helpseller.Entity.OrdineProdotto;


@SpringBootTest
public class OrdineProdottoControllerTest {

    @Autowired
    private OrdineProdottoController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    OrdineProdotto OrdineProdotto = new OrdineProdotto();
    assertThat(controller.findId(OrdineProdotto).getBody().getClass().equals("OrdineProdotto"));
    assertThat(controller.findId(OrdineProdotto).getBody().getQuantita()>0);
    assertThat(controller.findId(OrdineProdotto).getBody().getIdProdotto()>0);
    assertThat(controller.findId(OrdineProdotto).getBody().getPrezzoUnitario()>0);
    }
}
