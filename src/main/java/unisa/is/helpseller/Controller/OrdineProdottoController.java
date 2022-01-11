
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
    
    @GetMapping("/findId/")
    public ResponseEntity<OrdineProdotto> findId(OrdineProdotto ordProd) {
        OrdineProdotto ordineProdotto = ordineprodottoService.findId(ordProd);
        return new ResponseEntity<>(ordineProdotto, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/")
    public ResponseEntity<OrdineProdotto> deleteId(OrdineProdotto ordProd) {
        ordineprodottoService.deleteId(ordProd);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<OrdineProdotto> insert(OrdineProdotto ordProd) {
        ordineprodottoService.insert(ordProd);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<OrdineProdotto> update(OrdineProdotto ordProd) {
        ordineprodottoService.udpate(ordProd);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
