
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.ScontoProdotto;
import unisa.is.helpseller.Model.ScontoProdottoModel;

@RestController
@RequestMapping("/scontoprodotto")
@CrossOrigin("http://localhost:4200")
public class ScontoProdottoController {
    private final ScontoProdottoService scontoProdottoService;
    
    @Autowired
    public ScontoProdottoController(ScontoProdottoService scontoProdottoService) {this.scontoProdottoService = scontoProdottoService;}
    
      @GetMapping("/findAll")
    public ResponseEntity<List<ScontoProdotto>> findAll() {
        List<ScontoProdotto> scontoProdotti = scontoProdottoService.findAll();
        return new ResponseEntity<>(scontoProdotti, HttpStatus.OK);
    }
    
    @GetMapping("/findBySconto/{id}")
    public ResponseEntity<ScontoProdotto> findBySconto(@PathVariable("id") int id) {
        ScontoProdotto scontoProdotto = scontoProdottoService.findBySconto(id);
        return new ResponseEntity<>(scontoProdotto, HttpStatus.OK);
    }
    
    @GetMapping("/findByProdotto/{id}")
    public ResponseEntity<ScontoProdotto> findByProdotto(@PathVariable("id") int id) {
        ScontoProdotto scontoProdotto = scontoProdottoService.findByProdotto(id);
        return new ResponseEntity<>(scontoProdotto, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<ScontoProdotto> deleteId(@PathVariable("id") int id) {
        scontoProdottoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<ScontoProdotto> insert(ScontoProdotto scontoProd) {
        scontoProdottoService.insert(scontoProd);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<ScontoProdotto> update(ScontoProdotto updated, ScontoProdotto old) {
        scontoProdottoService.udpate(updated, old);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /*@GetMapping("/findProdottiScontatiAzienda/{name}/{id}")
    public ResponseEntity<List<ScontoProdottoModel>> findProdottiScontatiAzienda(@PathVariable("name") String name, @PathVariable("id") int id) {
        List<Object[]> obj = scontoProdottoService.findProdottiScontatiAzienda(name, id);
        
    }*/
}
