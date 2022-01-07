package unisa.is.helpseller.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


@SpringBootTest
public class AmministratoreControllerTest {

    @Autowired
    private AmministratoreController controller;

    @Test
    public void contextLoads() throws Exception {
    assertThat(controller.findAll().getBody().isEmpty()).isFalse();
    assertThat(controller.findId(1).getStatusCode().equals(HttpStatus.OK));
    assertThat(controller.findId(1000).getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
    assertThat(controller.deleteId(50).getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}