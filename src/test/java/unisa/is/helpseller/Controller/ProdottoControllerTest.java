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
public class ProdottoControllerTest {

    @Autowired
    private ProdottoController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId(1).getBody().getClass().equals("Prodotto"));
    assertThat(controller.findId(1).getBody().getQuantita()>0);
    assertThat(controller.findId(1).getBody().getId()>0);
    assertThat(controller.findId(1).getBody().getIdAzienda()>0);
    assertThat(controller.findId(1).getBody().getPeso()>0);
    assertThat(controller.findId(1).getBody().getDescrizione()!=null);
    assertThat(controller.findId(1).getBody().getImmagine()!=null);
    assertThat(controller.findId(1).getBody().getNomeProdotto()!=null);
    assertThat(controller.findId(1).getBody().getQuantitaMinima()>0);
    assertThat(controller.findId(1).getBody().getPrezzo()>0);
    assertThat(controller.findId(1).getBody().getVolume()>0);
    }
}