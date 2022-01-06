
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AmministratoreService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Amministratore;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AmministratoreController {
    private final AmministratoreService amministratoreService;
    
    @Autowired
    public AmministratoreController(AmministratoreService amministratoreService) {this.amministratoreService = amministratoreService;}
    
    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<Amministratore>> getAllAdmin() {
        List<Amministratore> amministratori = amministratoreService.findAllAmministratore();
        return new ResponseEntity<>(amministratori, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Amministratore> findAmministratore(@PathVariable("id") int id) {
        Amministratore amministratore = amministratoreService.findAmministratore(id);
        return new ResponseEntity<>(amministratore, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Amministratore> deleteAmministratore(@PathVariable("id") int id) {
        amministratoreService.deleteAmministratore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
