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
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import unisa.is.helpseller.Entity.ScontoProdotto;


@SpringBootTest
public class ScontoProdottoControllerTest {

    @Autowired
    private ScontoProdottoController controller;

    @Test
    public void contextLoads() throws Exception {
    /*assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findBySconto(1).getBody().getClass().equals("ScontoProdotto"));
    assertThat(controller.findByProdotto(1).getBody().getIdProdotto()>0);*/
    }
}