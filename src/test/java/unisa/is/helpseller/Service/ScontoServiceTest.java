/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisa.is.helpseller.Service;
import java.sql.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author UTENTE
 */
@SpringBootTest
public class ScontoServiceTest {
    @Autowired
    private ScontoService service;

    @Test
    public void contextLoads() throws Exception {
    assertThat(service.findAll().isEmpty()).isFalse();
    assertThat(service.findId(1).getId()).isEqualTo(1);
    assertThat(service.findId(1000).getId()).isEqualTo(null);
    
    for(int i=0; i<=service.findAll().size();i++){
        Date dataInizio=service.findId(i).getDataInizio();
        assertThat(service.findId(i).getDataFine().after(dataInizio));
    }
    }
}