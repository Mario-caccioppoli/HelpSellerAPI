
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AziendaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Azienda;

@RestController
@RequestMapping("/azienda")
@CrossOrigin("http://localhost:4200")
public class AziendaController {
    private final AziendaService aziendaService;
    
    @Autowired
    public AziendaController(AziendaService aziendaService) {this.aziendaService = aziendaService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Azienda>> findAll() {
        List<Azienda> aziende = aziendaService.findAll();
        return new ResponseEntity<>(aziende, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Azienda> findId(@PathVariable("id") int id) {
        Azienda azienda = aziendaService.findId(id);
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Azienda> deleteId(@PathVariable("id") int id) {
        aziendaService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Azienda> insert(String email, String password, String nome_azienda, 
           String indirizzo,  String vat, String descrizione, String logo) {
        aziendaService.insert(email, password, nome_azienda, indirizzo, vat, descrizione, logo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/updatePassword/{id}")
    public ResponseEntity<Azienda> updatePassword(String value, @PathVariable("id") int id) {
        aziendaService.updatePassword(value, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
