
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
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Ordine>> findAll() {
        List<Ordine> ordini = ordineService.findAll();
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Ordine> findId(@PathVariable("id") int id) {
        Ordine ordine = ordineService.findId(id);
        return new ResponseEntity<>(ordine, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Ordine> deleteId(@PathVariable("id") int id) {
        ordineService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Ordine> insert(Ordine ord) {
        ordineService.insert(ord);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Ordine> update(Ordine ord) {
        ordineService.update(ord);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/findOrdiniByDistributore/{id}") 
    public ResponseEntity<List<Ordine>> findOrdiniByDistributore(@PathVariable("id") int id) {
        List<Ordine> ordini = ordineService.findOrdiniByDistributore(id);
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }
    
    @GetMapping("/findOrdiniByAzienda/{id}")
    public ResponseEntity<List<Ordine>> findOrdiniByAzienda(@PathVariable("id") int id) {
        List<Ordine> ordini = ordineService.findOrdiniByAzienda(id);
        return new ResponseEntity<>(ordini, HttpStatus.OK);
    }
}
