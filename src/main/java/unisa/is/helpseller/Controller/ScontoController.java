
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Sconto;

@RestController
@RequestMapping("/sconto")
@CrossOrigin("http://localhost:4200")
public class ScontoController {
	@Autowired
    private final ScontoService scontoService;
    
    @Autowired
    public ScontoController(ScontoService scontoService) {this.scontoService = scontoService;}
    
      @GetMapping("/findAll")
    public ResponseEntity<List<Sconto>> findAll() {
    	  try
  		{
    	        List<Sconto> sconti = scontoService.findAll();
    	        return new ResponseEntity<>(sconti, HttpStatus.OK);
  		}catch (Exception ex)
  		{
  			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Sconto> findId(@PathVariable("id") int id) {
    	try
		{
            Sconto sconto = scontoService.findId(id);
            return new ResponseEntity<>(sconto, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Sconto> deleteId(@PathVariable("id") int id) {
    	try
		{
            scontoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Sconto> insert(Sconto sc) {
    	try
		{
            scontoService.insert(sc);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<Sconto> update(Sconto sc) {
    	try
		{
            scontoService.udpate(sc);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findScontiByAzienda/{id}") 
    public ResponseEntity<List<Sconto>> findScontiByAzienda(@PathVariable("id") int id) {
    	try
		{
            List<Sconto> sconti = scontoService.findScontiByAzienda(id);
            return new ResponseEntity<>(sconti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findScontiByTipo/{tipo}")
    public ResponseEntity<List<Sconto>> findScontiByTipo(@PathVariable("tipo") String tipo) {
    	try
		{
            List<Sconto> sconti = scontoService.findScontiByTipo(tipo);
            return new ResponseEntity<>(sconti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
