
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Model.ScontoProdotto;

@RestController
@RequestMapping("/scontoprodotto")
@CrossOrigin("http://localhost:4200")
public class ScontoProdottoController {
    private final ScontoProdottoService scontoProdottoService;
    
    @Autowired
    public ScontoProdottoController(ScontoProdottoService scontoProdottoService) {this.scontoProdottoService = scontoProdottoService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<ScontoProdotto>> getAllScontoProdotto() {
        List<ScontoProdotto> scontiProdotti = scontoProdottoService.findAllScontoProdotto();
        return new ResponseEntity<>(scontiProdotti, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<ScontoProdotto> findScontoProdottoById(@PathVariable("id") Long id) {
        ScontoProdotto scontoProdotto = scontoProdottoService.findScontoProdottoById(id);
        return new ResponseEntity<>(scontoProdotto, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<ScontoProdotto> addScontoProdotto(@RequestBody ScontoProdotto scontoProdotto) {
        ScontoProdotto newScontoProdotto = scontoProdottoService.addScontoProdotto(scontoProdotto);
        return new ResponseEntity<>(newScontoProdotto, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<ScontoProdotto> updateScontoProdotto(@RequestBody ScontoProdotto scontoProdotto) {
        ScontoProdotto updated = scontoProdottoService.updateScontoProdotto(scontoProdotto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ScontoProdotto> deleteScontoProdotto(@PathVariable("id") Long id) {
        scontoProdottoService.deleteScontoProdotto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
