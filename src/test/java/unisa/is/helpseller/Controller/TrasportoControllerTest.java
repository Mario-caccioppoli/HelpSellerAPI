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
public class TrasportoControllerTest {

    @Autowired
    private TrasportoController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId(1).getBody().getId()>0);
    assertThat(controller.findId(1).getBody().getClass().equals("Trasporto"));
    assertThat(controller.findId(1).getBody().getIdOrdine()>0);
    assertThat(controller.findId(1).getBody().getDataConsegna()!= null);
    assertThat(controller.findId(1).getBody().getQuantitaMinima()>0);
    assertThat(controller.findId(1).getBody().getIndirizzoConsegna()!= null);
    }
}
