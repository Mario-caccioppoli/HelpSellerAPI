
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
    
    @GetMapping("/getall")
    public ResponseEntity<List<Trasporto>> getAllTrasporto() {
        List<Trasporto> trasporti = trasportoService.findAllTrasporto();
        return new ResponseEntity<>(trasporti, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Trasporto> findTrasportoById(@PathVariable("id") Long id) {
        Trasporto trasporto = trasportoService.findTrasportoById(id);
        return new ResponseEntity<>(trasporto, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Trasporto> addTrasporto(@RequestBody Trasporto trasporto) {
        Trasporto newTrasporto = trasportoService.addTrasporto(trasporto);
        return new ResponseEntity<>(newTrasporto, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Trasporto> updateTrasporto(@RequestBody Trasporto trasporto) {
        Trasporto updated = trasportoService.updateTrasporto(trasporto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trasporto> deleteTrasporto(@PathVariable("id") Long id) {
        trasportoService.deleteTrasporto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
