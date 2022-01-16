
package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineProdottoService;
import java.util.List;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Model.OrdineProdottoModel;

@RestController
@RequestMapping("/ordineprodotto")
@CrossOrigin("http://localhost:4200")
public class OrdineProdottoController {
	@Autowired
    private final OrdineProdottoService ordineprodottoService;
    
    @Autowired
    public OrdineProdottoController(OrdineProdottoService ordineprodottoService) {this.ordineprodottoService = ordineprodottoService;}
    
     @GetMapping("/findAll")
    public ResponseEntity<List<OrdineProdotto>> findAll() {
    	 try
 		{
    	        List<OrdineProdotto> ordineProdotti = ordineprodottoService.findAll();
    	        return new ResponseEntity<>(ordineProdotti, HttpStatus.OK);
 		}catch (Exception ex)
 		{
 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 		}
    }
    
    @GetMapping("/findId/{idOrdine}/{idProdotto}")
    public ResponseEntity<OrdineProdotto> findId(@PathVariable("idOrdine") int idOrdine,@PathVariable("idProdotto") int idProdotto) {
    	try
		{
    		OrdineProdotto ordProd = new OrdineProdotto();
    		ordProd.setIdOrdine(idOrdine);
    		ordProd.setIdProdotto(idProdotto);
    		System.out.println(ordProd);
            OrdineProdotto ordineProdotto = ordineprodottoService.findId(ordProd);
            return new ResponseEntity<>(ordineProdotto, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @DeleteMapping("/deleteId/{idOrdine}/{idProdotto}")
    public ResponseEntity<OrdineProdotto> deleteId(@PathVariable("idOrdine") int idOrdine,@PathVariable("idProdotto") int idProdotto) {
    	try
		{
    		OrdineProdotto ordProd = new OrdineProdotto();
    		ordProd.setIdOrdine(idOrdine);
    		ordProd.setIdProdotto(idProdotto);
            ordineprodottoService.deleteId(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/insert")
    public ResponseEntity<OrdineProdotto> insert(OrdineProdotto ordProd) {
    	try
		{
            ordineprodottoService.insert(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/update")
    public ResponseEntity<OrdineProdotto> update(OrdineProdotto ordProd) {
    	try
		{
            ordineprodottoService.udpate(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/findDettagliOrdine/{id}")
    public ResponseEntity<List<OrdineProdottoModel>> findDettagliOrdine(@PathVariable("id") int id) {
    	try
		{
            List<OrdineProdotto> opList = ordineprodottoService.findDettagliOrdine(id);
            List<Prodotto> pList = ordineprodottoService.findDettagliProdotto(id);
            List<OrdineProdottoModel> opmList = new ArrayList<OrdineProdottoModel>();
            
            if(opList.size() == pList.size()) {
               for(int i = 0; i < opList.size(); i++) {
                   OrdineProdottoModel opmBuf = new OrdineProdottoModel (
                           opList.get(i).getIdOrdine(), opList.get(i).getQuantitaOrdine(), 
                           opList.get(i).getPrezzoUnitario(), pList.get(i));
                   
                   opmList.add(opmBuf);
               }
           } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(opmList, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    /*
    @GetMapping("/findDettagliOrdineProdotto/{id}")
    public ResponseEntity<List<Object[]>> findDettagliOrdineProdotto(@PathVariable("id") int id) {
        List<Object[]>
        
    }*/
}
