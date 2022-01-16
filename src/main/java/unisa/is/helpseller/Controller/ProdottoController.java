
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Model.ScontoProdottoModel;

@RestController
@RequestMapping("/prodotto")
@CrossOrigin("http://localhost:4200")
public class ProdottoController {
	@Autowired
    private final ProdottoService prodottoService;
    
    @Autowired
    public ProdottoController(ProdottoService prodottoService) {this.prodottoService = prodottoService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Prodotto>> findAll() {
    	try
		{
            List<Prodotto> prodotti = prodottoService.findAll();
            return new ResponseEntity<>(prodotti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Prodotto> findId(@PathVariable("id") int id) {
    	try
		{
            Prodotto prodotto = prodottoService.findId(id);
            return new ResponseEntity<>(prodotto, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Prodotto> deleteId(@PathVariable("id") int id) {
    	try
		{
            prodottoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Prodotto> insert(Prodotto prod) {
    	try
		{
            prodottoService.insert(prod);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<Prodotto> update(Prodotto prod) {
    	try
		{
            prodottoService.udpate(prod);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findProdottiByAzienda/{id}") 
    public ResponseEntity<List<Prodotto>> findProdottiByAzienda(@PathVariable("id") int id) {
    	try
		{
            List<Prodotto> prodotti = prodottoService.findProdottiByAzienda(id);
            return new ResponseEntity<>(prodotti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findProdottiByNome/{name}")
    public ResponseEntity<List<Prodotto>> findProdottiByNome(@PathVariable("name") String name) {
    	try
		{
            List<Prodotto> prodotti = prodottoService.findProdottiByNome(name);
            return new ResponseEntity<>(prodotti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findProdottiByNomeInAzienda/{name}/{id}")
    public ResponseEntity<List<Prodotto>> findProdottiByNomeInAzienda(@PathVariable("name") String name, @PathVariable("id") int id) {
    	try
		{
            List<Prodotto> prodotti = prodottoService.findProdottiByNomeInAzienda(name, id);
            return new ResponseEntity<>(prodotti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findProdottiInOrdine/{id}")
    public ResponseEntity<List<Prodotto>> findProdottiInOrdine(@PathVariable("id") int id) {
    	try
		{
            List<Prodotto> prodotti = prodottoService.findProdottiInOrdine(id);
            return new ResponseEntity<>(prodotti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findProdottiBySconto/{id}")
    public ResponseEntity<List<Prodotto>> findProdottiInSconto(@PathVariable("id") int id) {
    	try
		{
            List<Prodotto> prodotti = prodottoService.findProdottiBySconto(id);
            return new ResponseEntity<>(prodotti, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    

}

