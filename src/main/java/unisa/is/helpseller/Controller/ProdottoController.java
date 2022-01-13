
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
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Prodotto>> findAll() {
        List<Prodotto> prodotti = prodottoService.findAll();
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Prodotto> findId(@PathVariable("id") int id) {
        Prodotto prodotto = prodottoService.findId(id);
        return new ResponseEntity<>(prodotto, HttpStatus.OK);
    }

    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Prodotto> deleteId(@PathVariable("id") int id) {
        prodottoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Prodotto> insert(Prodotto prod) {
        prodottoService.insert(prod);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Prodotto> update(Prodotto prod) {
        prodottoService.udpate(prod);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/findProdottiByAzienda/{id}") 
    public ResponseEntity<List<Prodotto>> findProdottiByAzienda(@PathVariable("id") int id) {
        List<Prodotto> prodotti = prodottoService.findProdottiByAzienda(id);
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }
    
    @GetMapping("/findProdottiByNome/{name}")
    public ResponseEntity<List<Prodotto>> findProdottiByNome(@PathVariable("name") String name) {
        List<Prodotto> prodotti = prodottoService.findProdottiByNome(name);
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }
    
    @GetMapping("/findProdottiByNomeInAzienda/{name}/{id}")
    public ResponseEntity<List<Prodotto>> findProdottiByNomeInAzienda(@PathVariable("name") String name, @PathVariable("id") int id) {
        List<Prodotto> prodotti = prodottoService.findProdottiByNomeInAzienda(name, id);
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }
    
    @GetMapping("findProdottiInOrdine/{id}")
    public ResponseEntity<List<Prodotto>> findProdottiInOrdine(@PathVariable("id") int id) {
        List<Prodotto> prodotti = prodottoService.findProdottiInOrdine(id);
        return new ResponseEntity<>(prodotti, HttpStatus.OK);
    }
}

