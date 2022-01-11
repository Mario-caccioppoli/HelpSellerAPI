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
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import unisa.is.helpseller.Entity.Sconto;


@SpringBootTest
public class ScontoControllerTest {

    @Autowired
    private ScontoController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId(1).getBody().getClass().equals("Sconto"));
    assertThat(controller.findId(1).getBody().getTipo()== null).isFalse();
    assertThat(controller.findId(1).getBody().getId()>0);
    assertThat(controller.findId(1).getBody().getDataFine()!= null);
    assertThat(controller.findId(1).getBody().getIdAzienda()>0);
    assertThat(controller.findId(1).getBody().getDataInizio()!= null);
    assertThat(controller.findId(1).getBody().getPercentuale()>0);
    assertThat(controller.findId(1).getBody().getTipo()!= null);
    assertThat(controller.findId(1).getBody().getQuantita()>0);
        int i,m;
        List<Sconto> s=controller.findAll().getBody();
        m=s.size();
    for( i=0; i<=m;i++){
        Date dataInizio=s.get(i).getDataInizio();
        assertThat(s.get(i).getDataFine().after(dataInizio));
 
                        }
    }
}
