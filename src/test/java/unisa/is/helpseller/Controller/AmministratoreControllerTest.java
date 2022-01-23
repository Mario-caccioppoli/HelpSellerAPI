package unisa.is.helpseller.Controller;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.AmministratoreModel;



@SpringBootTest
public class AmministratoreControllerTest {

    @Autowired
    private AmministratoreController controller;

    @Test
    public void findAllStatus() throws Exception {
    	ResponseEntity<List<AmministratoreModel>> response = controller.findAll();
    	List<AmministratoreModel> allAdmins = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(allAdmins).asList();
   }
  
    @Test
    public void findIncorrectId() throws Exception {
    	ResponseEntity<AmministratoreModel> response = controller.findId(-1);
    	AmministratoreModel admin = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND));
    	assertThat(admin).isNull();
   }
    @Test
    public void findCorrectId() throws Exception {
    	ResponseEntity<AmministratoreModel> response = controller.findId(2);
    	AmministratoreModel admin = response.getBody();
    	assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
    	assertThat(admin).isNotNull();
   }
    //int id, String email, String username, String password
    @Test
    public void Update() throws Exception {

    	AmministratoreModel admin = controller.findId(2).getBody();
        admin.setEmail("testmail");
        ResponseEntity<Integer> response = controller.update(admin);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK));
   }
}