
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.OrdineProdotto;

@RestController
@RequestMapping("/ordineprodotto")
@CrossOrigin("http://localhost:4200")
public class OrdineProdottoController {
    private final OrdineProdottoService ordineprodottoService;
    
    @Autowired
    public OrdineProdottoController(OrdineProdottoService ordineprodottoService) {this.ordineprodottoService = ordineprodottoService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<OrdineProdotto>> getAllOrdineProdotto() {
        List<OrdineProdotto> ordiniprodotti = ordineprodottoService.findAllOrdineProdotto();
        return new ResponseEntity<>(ordiniprodotti, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<OrdineProdotto> findOrdineProdottoById(@PathVariable("id") Long id) {
        OrdineProdotto ordineprodotto = ordineprodottoService.findOrdineProdottoById(id);
        return new ResponseEntity<>(ordineprodotto, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<OrdineProdotto> addOrdineProdotto(@RequestBody OrdineProdotto ordineprodotto) {
        OrdineProdotto newOrdineProdotto = ordineprodottoService.addOrdineProdotto(ordineprodotto);
        return new ResponseEntity<>(newOrdineProdotto, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<OrdineProdotto> updateOrdineProdotto(@RequestBody OrdineProdotto ordineprodotto) {
        OrdineProdotto updated = ordineprodottoService.updateOrdineProdotto(ordineprodotto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrdineProdotto> deleteOrdineProdotto(@PathVariable("id") Long id) {
        ordineprodottoService.deleteOrdineProdotto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
