package unisa.is.helpseller.Service;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author HELP SELLER
 */

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailSenderService senderService;

    @Test
    public void inviaMail() throws Exception {
        senderService.sendEmail("xlitsl0l@gmail.com", "email", "testo");
    }
    
    
    

    public void sendMail(){
        senderService.sendEmail("xlitsl0l@gmail.com", "email", "testo");
    }
}