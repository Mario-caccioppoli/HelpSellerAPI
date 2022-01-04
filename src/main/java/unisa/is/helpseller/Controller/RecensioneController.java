
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
    
    @GetMapping("/getall")
    public ResponseEntity<List<Recensione>> getAllRecensione() {
        List<Recensione> recensioni = recensioneService.findAllRecensione();
        return new ResponseEntity<>(recensioni, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Recensione> findRecensioneById(@PathVariable("id") Long id) {
        Recensione recensione = recensioneService.findRecensioneById(id);
        return new ResponseEntity<>(recensione, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Recensione> addRecensione(@RequestBody Recensione recensione) {
        Recensione newRecensione = recensioneService.addRecensione(recensione);
        return new ResponseEntity<>(newRecensione, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Recensione> updateRecensione(@RequestBody Recensione recensione) {
        Recensione updated = recensioneService.updateRecensione(recensione);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Recensione> deleteRecensione(@PathVariable("id") Long id) {
        recensioneService.deleteRecensione(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
