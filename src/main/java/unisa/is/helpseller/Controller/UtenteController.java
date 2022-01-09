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
    public UtenteModel auth(String username, String password){
        List<Amministratore> admin = adminService.findAll();
        List<Distributore> dist = distService.findAll();
        List<Azienda> azienda = aziendaService.findAll();
        return utenteService.auth(username, password, admin, dist, azienda);
    }
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

}


