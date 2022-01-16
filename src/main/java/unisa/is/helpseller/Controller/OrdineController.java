
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Ordine;

@RestController
@RequestMapping("/ordine")
@CrossOrigin("http://localhost:4200")
public class OrdineController {
	@Autowired
    private final OrdineService ordineService;
    
    @Autowired
    public OrdineController(OrdineService ordineService) {this.ordineService = ordineService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Ordine>> findAll() {
    	try
		{
            List<Ordine> ordini = ordineService.findAll();
            return new ResponseEntity<>(ordini, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Ordine> findId(@PathVariable("id") int id) {
    	try
		{
            Ordine ordine = ordineService.findId(id);
            return new ResponseEntity<>(ordine, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Ordine> deleteId(@PathVariable("id") int id) {
    	try
		{
            ordineService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Ordine> insert(Ordine ord) {
    	try
		{
            ordineService.insert(ord);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<Ordine> update(Ordine ord) {
    	try
		{
            ordineService.update(ord);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findOrdiniByDistributore/{id}") 
    public ResponseEntity<List<Ordine>> findOrdiniByDistributore(@PathVariable("id") int id) {
    	try
		{
            List<Ordine> ordini = ordineService.findOrdiniByDistributore(id);
            return new ResponseEntity<>(ordini, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findOrdiniByAzienda/{id}")
    public ResponseEntity<List<Ordine>> findOrdiniByAzienda(@PathVariable("id") int id) {
    	try
		{
            List<Ordine> ordini = ordineService.findOrdiniByAzienda(id);
            return new ResponseEntity<>(ordini, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
