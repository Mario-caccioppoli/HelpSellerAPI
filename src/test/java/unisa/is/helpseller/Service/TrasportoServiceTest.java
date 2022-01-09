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
/**
 *
 * @author UTENTE
 */
@SpringBootTest
public class TrasportoServiceTest {
    @Autowired
    private TrasportoService service;

    @Test
    public void contextLoads() throws Exception {
    assertThat(service.findAll().isEmpty()).isFalse();
    assertThat(service.findId(1).getClass().equals("Prodotto"));
    assertThat(service.findId(1).getDataConsegna().equals(null)).isFalse();
    assertThat(service.findId(1).getId()>0);
    assertThat(service.findId(1).getIndirizzoConsegna()!= null);
    assertThat(service.findId(1).getIdOrdine()>0);
    assertThat(service.findId(1).getQuantitaMinima()>0);
    }
}
