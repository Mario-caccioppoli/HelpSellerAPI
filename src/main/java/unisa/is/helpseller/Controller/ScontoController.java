
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Sconto;

@RestController
@RequestMapping("/sconto")
@CrossOrigin("http://localhost:4200")
public class ScontoController {
    private final ScontoService scontoService;
    
    @Autowired
    public ScontoController(ScontoService scontoService) {this.scontoService = scontoService;}
    
      @GetMapping("/findAll")
    public ResponseEntity<List<Sconto>> findAll() {
        List<Sconto> sconti = scontoService.findAll();
        return new ResponseEntity<>(sconti, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Sconto> findId(@PathVariable("id") int id) {
        Sconto sconto = scontoService.findId(id);
        return new ResponseEntity<>(sconto, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Sconto> deleteId(@PathVariable("id") int id) {
        scontoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Sconto> insert(Sconto sc) {
        scontoService.insert(sc);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Sconto> update(Sconto sc) {
        scontoService.udpate(sc);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/findScontiByAzienda/{id}") 
    public ResponseEntity<List<Sconto>> findScontiByAzienda(@PathVariable("id") int id) {
        List<Sconto> sconti = scontoService.findScontiByAzienda(id);
        return new ResponseEntity<>(sconti, HttpStatus.OK);
    }
}
