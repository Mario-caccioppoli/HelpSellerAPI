
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AziendaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.Azienda;

@RestController
@RequestMapping("/azienda")
@CrossOrigin("http://localhost:4200")
public class AziendaController {
    private final AziendaService aziendaService;
    
    @Autowired
    public AziendaController(AziendaService aziendaService) {this.aziendaService = aziendaService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<Azienda>> getAllAzienda() {
        List<Azienda> aziende = aziendaService.findAllAzienda();
        return new ResponseEntity<>(aziende, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Azienda> findAziendaById(@PathVariable("id") Long id) {
        Azienda azienda = aziendaService.findAziendaById(id);
        return new ResponseEntity<>(azienda, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Azienda> addAzienda(@RequestBody Azienda azienda) {
        Azienda newAzienda = aziendaService.addAzienda(azienda);
        return new ResponseEntity<>(newAzienda, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Azienda> updateAzienda(@RequestBody Azienda azienda) {
        Azienda updated = aziendaService.updateAzienda(azienda);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Azienda> deleteAzienda(@PathVariable("id") Long id) {
        aziendaService.deleteAzienda(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
