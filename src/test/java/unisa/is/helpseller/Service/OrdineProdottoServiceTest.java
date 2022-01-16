/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Service;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Model.OrdineModel;
import unisa.is.helpseller.Model.OrdineProdottoModel;
/**
 *
 * @author UTENTE
 */
@SpringBootTest
public class OrdineProdottoServiceTest {
    @Autowired
    private OrdineProdottoService service;

    @Test
    public void contextLoads() throws Exception {
    }
}
