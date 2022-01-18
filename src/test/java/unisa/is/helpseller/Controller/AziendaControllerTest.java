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
    assertThat(controller.findAziendeByNome(null).getBody().getClass().equals("Azienda"));
    }
}