
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.Sconto;

@RestController
@RequestMapping("/sconto")
@CrossOrigin("http://localhost:4200")
public class ScontoController {
    private final ScontoService scontoService;
    
    @Autowired
    public ScontoController(ScontoService scontoService) {this.scontoService = scontoService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<Sconto>> getAllSconto() {
        List<Sconto> sconti = scontoService.findAllSconto();
        return new ResponseEntity<>(sconti, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Sconto> findScontoById(@PathVariable("id") Long id) {
        Sconto sconto = scontoService.findScontoById(id);
        return new ResponseEntity<>(sconto, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Sconto> addSconto(@RequestBody Sconto sconto) {
        Sconto newSconto = scontoService.addSconto(sconto);
        return new ResponseEntity<>(newSconto, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Sconto> updateSconto(@RequestBody Sconto sconto) {
        Sconto updated = scontoService.updateSconto(sconto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sconto> deleteSconto(@PathVariable("id") Long id) {
        scontoService.deleteSconto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
