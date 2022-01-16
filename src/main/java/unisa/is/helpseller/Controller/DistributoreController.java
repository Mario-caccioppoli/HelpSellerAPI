
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
	@Autowired
    private final DistributoreService distributoreService;
    
    @Autowired
    public DistributoreController(DistributoreService distributoreService) {this.distributoreService = distributoreService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Distributore>> findAll() {
    	try
		{
            List<Distributore> distributori = distributoreService.findAll();
            return new ResponseEntity<>(distributori, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Distributore> findId(@PathVariable("id") int id) {
    	try
		{
            Distributore distributore = distributoreService.findId(id);
            return new ResponseEntity<>(distributore, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Distributore> deleteId(@PathVariable("id") int id) {
    	try
		{
            distributoreService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Distributore> insert(Distributore d) {
    	try
		{
    		 distributoreService.insert(d);
    	        return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<Distributore> update(Distributore d) {
    	try
		{
    		distributoreService.update(d);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
