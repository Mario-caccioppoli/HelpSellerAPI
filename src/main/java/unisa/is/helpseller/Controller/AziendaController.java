
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AziendaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Azienda;

@RestController
@RequestMapping("/azienda")
@CrossOrigin("http://localhost:4200")
public class AziendaController {
	
	@Autowired
    private final AziendaService aziendaService;
    
    @Autowired
    public AziendaController(AziendaService aziendaService) {this.aziendaService = aziendaService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Azienda>> findAll() {
    	try
		{
    		List<Azienda> aziende = aziendaService.findAll();
            return new ResponseEntity<>(aziende, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Azienda> findId(@PathVariable("id") int id) {
    	try
		{
    		Azienda azienda = aziendaService.findId(id);
            return new ResponseEntity<>(azienda, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Azienda> deleteId(@PathVariable("id") int id) {
    	try
		{
    		 aziendaService.deleteId(id);
    	        return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Azienda> insert(Azienda  a) {
    	try
		{
    		aziendaService.insert(a);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    }
    
    @PostMapping("/update")
    public ResponseEntity<Azienda> update(Azienda a) {
    	try
		{
    		aziendaService.update(a);
    		return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findAziendaByNome/{name}")
    public ResponseEntity<List<Azienda>> findAziendeByNome(@PathVariable("name") String name) {
    	try
		{
    		 List<Azienda> aziende = aziendaService.findAziendeByNome(name);
    	     return new ResponseEntity<>(aziende, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findAziendaByProdotto/{id}")
    public ResponseEntity<Azienda> findAziendaByProdotto(@PathVariable("id") int id) {
    	try
		{
    		 Azienda azienda = aziendaService.findAziendaByProdotto(id);
    	        return new ResponseEntity<>(azienda, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
