package unisa.is.helpseller.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


@SpringBootTest
public class AziendaControllerTest {

    @Autowired
    private AziendaController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId(1).getBody().getClass().equals("Azienda"));
    assertThat(controller.findId(1).getBody().getEmail().equals(null)).isFalse();
    assertThat(controller.findId(1).getBody().getId()>0);
    assertThat(controller.findId(1).getBody().getPassword()!= null);
    }
}