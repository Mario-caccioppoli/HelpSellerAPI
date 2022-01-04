
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Prodotto;

@RestController
@RequestMapping("/prodotto")
@CrossOrigin("http://localhost:4200")
public class ProdottoController {
    private final ProdottoService prodottoService;
    
    @Autowired
    public ProdottoController(ProdottoService prodottoService) {this.prodottoService = prodottoService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<Prodotto>> getAllProdotto() {
        List<Prodotto> prodotti = prodottoService.findAllProdotto();
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Prodotto> findProdottoById(@PathVariable("id") Long id) {
        Prodotto prodotto = prodottoService.findProdottoById(id);
        return new ResponseEntity<>(prodotto, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Prodotto> addProdotto(@RequestBody Prodotto prodotto) {
        Prodotto newProdotto = prodottoService.addProdotto(prodotto);
        return new ResponseEntity<>(newProdotto, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Prodotto> updateProdotto(@RequestBody Prodotto prodotto) {
        Prodotto updated = prodottoService.updateProdotto(prodotto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Prodotto> deleteProdotto(@PathVariable("id") Long id) {
        prodottoService.deleteProdotto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
