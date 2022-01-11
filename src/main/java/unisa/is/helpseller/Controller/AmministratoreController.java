
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
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Amministratore>> findAll() {
        List<Amministratore> amministratori = amministratoreService.findAll();
        return new ResponseEntity<>(amministratori, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Amministratore> findId(@PathVariable("id") int id) {
        Amministratore amministratore = amministratoreService.findId(id);
        return new ResponseEntity<>(amministratore, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Amministratore> deleteId(@PathVariable("id") int id) {
        amministratoreService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Amministratore> insert(Amministratore a) {
        amministratoreService.insert(a);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Amministratore> update(Amministratore a) {
        amministratoreService.udpate(a);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
