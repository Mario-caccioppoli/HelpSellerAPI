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


@SpringBootTest
public class RecensioneControllerTest {

    @Autowired
    private RecensioneController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId().isEmpty()).isFalse();
    assertThat(controller.deleteId().getBody().isEmpty()).isFalse();
    }
}
