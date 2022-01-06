
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
    
     @GetMapping("/findAll")
    public ResponseEntity<List<OrdineProdotto>> findAll() {
        List<OrdineProdotto> ordineProdotti = ordineprodottoService.findAll();
        return new ResponseEntity<>(ordineProdotti, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<OrdineProdotto> findId(@PathVariable("id") int id) {
        OrdineProdotto ordineProdotto = ordineprodottoService.findId(id);
        return new ResponseEntity<>(ordineProdotto, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<OrdineProdotto> deleteId(@PathVariable("id") int id) {
        ordineprodottoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
