package unisa.is.helpseller.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private final UtenteService utenteService;
    
    @Autowired
    private AmministratoreService adminService;
    @Autowired
    private DistributoreService distService;
    @Autowired
    private AziendaService aziendaService;
    
    @Autowired
    public UtenteController(UtenteService utenteService) {this.utenteService = utenteService;}
    
    
    @PostMapping("/login")
    public UtenteModel auth(String email, String password, String tipo){
        if(tipo.equals("Amministratore")){
            List<Amministratore> admin = adminService.findAll();
            return utenteService.authAdmin(email, password, admin);
        }
        
        if(tipo.equals("Distributore")){
            List<Distributore> dist = distService.findAll();
            return utenteService.authDist(email, password, dist);
        }
        
        if(tipo.equals("Azienda")){
            List<Azienda> azienda = aziendaService.findAll();
            return utenteService.authAzienda(email, password, azienda);
        }
        
        return null;
    }
    
    @PostMapping("/regAdmin")
    public void regAdmin(String username, String password, String email){
        adminService.insert(username, email, password);
    }
    
    @PostMapping("/regAzienda")
    public void registrazione(String email, String password, String nome_azienda, 
           String indirizzo,  String vat, String descrizione, String logo){
        
        aziendaService.insert(email, password, nome_azienda, indirizzo, vat, descrizione, logo);
    }
    
    @PostMapping("/regDistributore")
    public void registrazione(String username, String email, String password, 
              String nome, String cognome, String telefono, 
              String indirizzo_sede, int id_ordine_prova, String vat){

        distService.insert(username, email, password, nome, cognome, telefono, indirizzo_sede, id_ordine_prova, vat);
    }
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

}


