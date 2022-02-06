package unisa.is.helpseller.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RaccomandazioneControllerTest {

    @Autowired
    private RaccomandazioneController controller;

    @Test
    public void data() throws Exception {
        controller.creaCsv();
    }

    @Test
    public void l1() throws Exception {
        controller.firstLayer();
    }
    @Test
    public void l2() throws Exception {
        controller.secondLayer(1);
    }

    @Test
    public void l2fail() throws Exception {
        controller.secondLayer(999);
    }

    @Test
    public void l2fail2() throws Exception {
        controller.secondLayer(7);
    }
}
