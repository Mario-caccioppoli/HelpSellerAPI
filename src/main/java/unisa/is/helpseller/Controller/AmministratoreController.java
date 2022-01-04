
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
    
    @GetMapping("/getall")
    public ResponseEntity<List<Amministratore>> getAllAdmin() {
        List<Amministratore> amministratori = amministratoreService.findAllAmministratore();
        return new ResponseEntity<>(amministratori, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Amministratore> findAdminById(@PathVariable("id") Long id) {
        Amministratore amministratore = amministratoreService.findAmministratoreById(id);
        return new ResponseEntity<>(amministratore, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Amministratore> addAdmin(@RequestBody Amministratore amministratore) {
        Amministratore newAmministratore = amministratoreService.addAmministratore(amministratore);
        return new ResponseEntity<>(newAmministratore, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Amministratore> updateAdmin(@RequestBody Amministratore amministratore) {
        Amministratore updated = amministratoreService.updateAmministratore(amministratore);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Amministratore> deleteAdmin(@PathVariable("id") Long id) {
        amministratoreService.deleteAmministratore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
