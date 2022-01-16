
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
	@Autowired
    private final TrasportoService trasportoService;
    
    @Autowired
    public TrasportoController(TrasportoService trasportoService) {this.trasportoService = trasportoService;}
    
      @GetMapping("/findAll")
    public ResponseEntity<List<Trasporto>> findAll() {
    	  try
  		{
    	        List<Trasporto> trasporti = trasportoService.findAll();
    	        return new ResponseEntity<>(trasporti, HttpStatus.OK);
  		}catch (Exception ex)
  		{
  			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Trasporto> findId(@PathVariable("id") int id) {
    	try
		{
            Trasporto trasporto = trasportoService.findId(id);
            return new ResponseEntity<>(trasporto, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Trasporto> deleteId(@PathVariable("id") int id) {
    	try
		{
            trasportoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Trasporto> insert(Trasporto tr) {
    	try
		{
            trasportoService.insert(tr);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<Trasporto> update(Trasporto tr) {
    	try
		{
            trasportoService.udpate(tr);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
}
