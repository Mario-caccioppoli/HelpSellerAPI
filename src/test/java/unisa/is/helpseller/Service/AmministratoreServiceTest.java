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
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Model.AmministratoreModel;

import java.util.List;

/**
 *
 * @author UTENTE
 */
@SpringBootTest
public class AmministratoreServiceTest {
    @Autowired
    private AmministratoreService service;


    @Test
    public void Entity(){
        Amministratore admin = new Amministratore("gino@admin.it", "gino", "123");
        admin.getEmail();
        admin.getId();
        admin.getPassword();
        admin.getUsername();
        admin.setEmail("email");
        admin.setPassword("asdsa");
        admin.setUsername("fgfg");
    }

    @Test
    public void Model(){
        AmministratoreModel admin = new AmministratoreModel(0, "gino@admin.it", "gino", "123");
        admin.getEmail();
        admin.getId();
        admin.getPassword();
        admin.getUsername();
        admin.setEmail("email");
        admin.setPassword("asdsa");
        admin.setUsername("fgfg");
    }

    @Test
    public void empty(){}

    @Test
    public void Service() throws Exception {
        List<Amministratore> list = service.findAll();
        assertThat(list).asList();
        Amministratore a = service.findId(3);
        assertThat(a).isNotNull();

        assertThat(service.udpate(a)).isNotNull();
        a.setEmail("nuovaemail");
        int id = service.insert(a);
        assertThat(id).isNotNull();
        assertThat(service.recuperoPassword(a.getEmail())).isNotNull();
        //assertThat(service.deleteId(id)).isNotNull();
    }
}
