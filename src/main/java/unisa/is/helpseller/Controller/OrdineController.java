
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Ordine;

@RestController
@RequestMapping("/ordine")
@CrossOrigin("http://localhost:4200")
public class OrdineController {
    private final OrdineService ordineService;
    
    @Autowired
    public OrdineController(OrdineService ordineService) {this.ordineService = ordineService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<Ordine>> getAllOrdine() {
        List<Ordine> ordini = ordineService.findAllOrdine();
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Ordine> findOrdineById(@PathVariable("id") Long id) {
        Ordine ordine = ordineService.findOrdineById(id);
        return new ResponseEntity<>(ordine, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Ordine> addOrdine(@RequestBody Ordine ordine) {
        Ordine newOrdine = ordineService.addOrdine(ordine);
        return new ResponseEntity<>(newOrdine, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Ordine> updateOrdine(@RequestBody Ordine ordine) {
        Ordine updated = ordineService.updateOrdine(ordine);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ordine> deleteOrdine(@PathVariable("id") Long id) {
        ordineService.deleteOrdine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
