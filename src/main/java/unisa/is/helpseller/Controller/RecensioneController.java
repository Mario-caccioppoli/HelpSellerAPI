
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.RecensioneService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Recensione;

@RestController
@RequestMapping("/recensione")
@CrossOrigin("http://localhost:4200")
public class RecensioneController {
	@Autowired
    private final RecensioneService recensioneService;
    
    @Autowired
    public RecensioneController(RecensioneService recensioneService) {this.recensioneService = recensioneService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Recensione>> findAll() {
    	try
		{
            List<Recensione> recensioni = recensioneService.findAll();
            return new ResponseEntity<>(recensioni, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Recensione> findId(@PathVariable("id") int id) {
    	try
		{
            Recensione recensione = recensioneService.findId(id);
            return new ResponseEntity<>(recensione, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Recensione> deleteId(@PathVariable("id") int id) {
    	try
		{
            recensioneService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Recensione> insert(Recensione rec) {
    	try
		{
            recensioneService.insert(rec);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<Recensione> update(Recensione rec) {
    	try
		{
            recensioneService.udpate(rec);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
