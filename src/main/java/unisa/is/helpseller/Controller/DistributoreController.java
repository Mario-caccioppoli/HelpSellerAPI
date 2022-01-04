
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DistributoreService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Distributore;

@RestController
@RequestMapping("/distributore")
@CrossOrigin("http://localhost:4200")
public class DistributoreController {
    private final DistributoreService distributoreService;
    
    @Autowired
    public DistributoreController(DistributoreService distributoreService) {this.distributoreService = distributoreService;}
    
    @GetMapping("/getall")
    public ResponseEntity<List<Distributore>> getAllDistributore() {
        List<Distributore> distributori = distributoreService.findAllDistributore();
        return new ResponseEntity<>(distributori, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Distributore> findDistributoreById(@PathVariable("id") Long id) {
        Distributore distributore = distributoreService.findDistributoreById(id);
        return new ResponseEntity<>(distributore, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Distributore> addDistributore(@RequestBody Distributore distributore) {
        Distributore newDistributore = distributoreService.addDistributore(distributore);
        return new ResponseEntity<>(newDistributore, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Distributore> updateDistributore(@RequestBody Distributore distributore) {
        Distributore updated = distributoreService.updateDistributore(distributore);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Distributore> deleteDistributore(@PathVariable("id") Long id) {
        distributoreService.deleteDistributore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
