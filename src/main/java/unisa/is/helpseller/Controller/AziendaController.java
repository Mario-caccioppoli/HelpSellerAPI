
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
    public ResponseEntity<Azienda> insert(Azienda  a) {
        aziendaService.insert(a);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Azienda> update(Azienda a) {
        aziendaService.update(a);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/findAziendaByNome/{name}")
    public ResponseEntity<Azienda> findAziendaByNome(@PathVariable("name") String name) {
        Azienda azienda = aziendaService.findAziendaByNome(name);
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }
    
    @GetMapping("/findAziendaByProdotto/{id}")
    public ResponseEntity<Azienda> findAziendaByProdotto(@PathVariable("id") int id) {
        Azienda azienda = aziendaService.findAziendaByProdotto(id);
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }
}
