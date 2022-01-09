
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DistributoreService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Distributore;

@RestController
@RequestMapping("/distributore")
@CrossOrigin("http://localhost:4200")
public class DistributoreController {
    private final DistributoreService distributoreService;
    
    @Autowired
    public DistributoreController(DistributoreService distributoreService) {this.distributoreService = distributoreService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Distributore>> findAll() {
        List<Distributore> distributori = distributoreService.findAll();
        return new ResponseEntity<>(distributori, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Distributore> findId(@PathVariable("id") int id) {
        Distributore distributore = distributoreService.findId(id);
        return new ResponseEntity<>(distributore, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Distributore> deleteId(@PathVariable("id") int id) {
        distributoreService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Distributore> insert(String username, String email, String password, 
              String nome, String cognome, String telefono, 
              String indirizzo_sede, int id_ordine_prova, String vat) {
        distributoreService.insert(username, email, password, nome, cognome, telefono, indirizzo_sede, id_ordine_prova, vat);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/updatePassword/{id}")
    public ResponseEntity<Distributore> updatePassword(String value, @PathVariable("id") int id) {
        distributoreService.updatePassword(value, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
