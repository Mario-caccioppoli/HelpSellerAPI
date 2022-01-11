
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.RecensioneService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Recensione;

@RestController
@RequestMapping("/recensione")
@CrossOrigin("http://localhost:4200")
public class RecensioneController {
    private final RecensioneService recensioneService;
    
    @Autowired
    public RecensioneController(RecensioneService recensioneService) {this.recensioneService = recensioneService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Recensione>> findAll() {
        List<Recensione> recensioni = recensioneService.findAll();
        return new ResponseEntity<>(recensioni, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Recensione> findId(@PathVariable("id") int id) {
        Recensione recensione = recensioneService.findId(id);
        return new ResponseEntity<>(recensione, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Recensione> deleteId(@PathVariable("id") int id) {
        recensioneService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Recensione> insert(Recensione rec) {
        recensioneService.insert(rec);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Recensione> update(Recensione rec) {
        recensioneService.udpate(rec);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
