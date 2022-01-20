package unisa.is.helpseller.Controller;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Model.UtenteModel;
import unisa.is.helpseller.Service.AmministratoreService;
import unisa.is.helpseller.Service.AziendaService;
import unisa.is.helpseller.Service.DistributoreService;
import unisa.is.helpseller.Service.UtenteService;

/**
 *
 * @author Alex
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UtenteController {
    @Autowired
    private final UtenteService utenteService;
    @Autowired
    private AmministratoreService adminService;
    @Autowired
    private DistributoreService distService;
    @Autowired
    private AziendaService aziendaService;
    
    @Autowired
    public UtenteController(UtenteService utenteService, 
            AmministratoreService adminService,
            DistributoreService distributoreService,
            AziendaService aziendaService) {
        this.utenteService = utenteService;
        this.adminService = adminService;
        this.distService = distributoreService;
        this.aziendaService = aziendaService;
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<UtenteModel> auth(@RequestBody String input){
    	UtenteModel utente = new UtenteModel();
        
        JSONObject json = new JSONObject(input);
        
    	try
		{
    		  if(json.getString("tipo").equals("Amministratore")){
    	            List<Amministratore> admin = adminService.findAll();
    	            utente = utenteService.authAdmin(json.getString("email"), json.getString("password"), admin);
    	        }
    	        else if(json.get("tipo").equals("Distributore")){
    	            List<Distributore> dist = distService.findAll();
    	            utente = utenteService.authDist(json.getString("email"), json.getString("password"), dist);
    	        }
    	        
    	        else if(json.get("tipo").equals("Azienda")){
    	            List<Azienda> azienda = aziendaService.findAll();
    	            utente = utenteService.authAzienda(json.getString("email"), json.getString("password"), azienda);
    	        }
    	        
    	        if(utente.getId() > 0)
    	        {
    	        	 return new ResponseEntity<UtenteModel>(utente,HttpStatus.OK);
    	        }
    	        else {
    	        	 return new ResponseEntity<UtenteModel>(HttpStatus.UNAUTHORIZED);
    	        }
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/regAdmin")
    public  ResponseEntity<UtenteModel> regAdmin(Amministratore a){
    	try
		{
    		 adminService.insert(a);
    		 return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/regAzienda")
    public  ResponseEntity<UtenteModel> registrazione(Azienda a){
    	try
		{
    		aziendaService.insert(a);
    		 return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/regDistributore")
    public  ResponseEntity<UtenteModel> registrazione(Distributore d){
    	try
		{
    		distService.insert(d);
    		 return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
}


