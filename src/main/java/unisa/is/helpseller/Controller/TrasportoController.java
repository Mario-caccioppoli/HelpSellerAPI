
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.TrasportoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Trasporto;

@RestController
@RequestMapping("/trasporto")
@CrossOrigin("http://localhost:4200")
public class TrasportoController {
    private final TrasportoService trasportoService;
    
    @Autowired
    public TrasportoController(TrasportoService trasportoService) {this.trasportoService = trasportoService;}
    
      @GetMapping("/findAll")
    public ResponseEntity<List<Trasporto>> findAll() {
        List<Trasporto> trasporti = trasportoService.findAll();
        return new ResponseEntity<>(trasporti, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Trasporto> findId(@PathVariable("id") int id) {
        Trasporto trasporto = trasportoService.findId(id);
        return new ResponseEntity<>(trasporto, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Trasporto> deleteId(@PathVariable("id") int id) {
        trasportoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Trasporto> insert(Trasporto tr) {
        trasportoService.insert(tr);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Trasporto> update(Trasporto tr) {
        trasportoService.udpate(tr);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
