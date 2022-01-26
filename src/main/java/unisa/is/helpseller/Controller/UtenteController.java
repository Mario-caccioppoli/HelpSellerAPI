package unisa.is.helpseller.Controller;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Model.UtenteModel;
import unisa.is.helpseller.Model.AziendaModel;
import unisa.is.helpseller.Model.DistributoreModel;
import unisa.is.helpseller.Service.AmministratoreService;
import unisa.is.helpseller.Service.AziendaService;
import unisa.is.helpseller.Service.DistributoreService;
import unisa.is.helpseller.Service.EmailSenderService;
import unisa.is.helpseller.Service.UtenteService;

/**
 * classe di mappatura dei servizi relativi ad Utente affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    private EmailSenderService senderService;

    @Autowired
    public UtenteController(UtenteService utenteService,
            AmministratoreService adminService,
            DistributoreService distributoreService,
            AziendaService aziendaService, EmailSenderService senderService) {
        this.utenteService = utenteService;
        this.adminService = adminService;
        this.distService = distributoreService;
        this.aziendaService = aziendaService;
        this.senderService = senderService;
    }

    /**
     * metodo per l'autenticazione dell'admin
     * @param input email email dell'utente password la sua password admin lista degli admin
     * @return oggetto dell'utente
     */
    @PostMapping("/login")
    public ResponseEntity<UtenteModel> auth(@RequestBody String input) {
        UtenteModel utente = new UtenteModel();

        JSONObject json = new JSONObject(input);

        try {
            if (json.getString("tipo").equals("Amministratore")) {
                List<Amministratore> admin = adminService.findAll();
                utente = utenteService.authAdmin(json.getString("email"), json.getString("password"), admin);
            } else if (json.get("tipo").equals("Distributore")) {
                List<Distributore> dist = distService.findAll();
                utente = utenteService.authDist(json.getString("email"), json.getString("password"), dist);
            } else if (json.get("tipo").equals("Azienda")) {
                List<Azienda> azienda = aziendaService.findAll();
                utente = utenteService.authAzienda(json.getString("email"), json.getString("password"), azienda);
            }
            return new ResponseEntity<UtenteModel>(utente, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * metodo per il recupero della password data la mail
     * @param email
     */
    @PostMapping("/recuperoPassword/{email}")
    public ResponseEntity<Integer> recuperoPassword(@PathVariable("email") String email) {
        try {
            String result = distService.recuperoPassword(email);
            if(!result.isEmpty()) {
                senderService.sendEmail(email, "Recupero Password", result);
                return new ResponseEntity<>(1, HttpStatus.OK);
            }
        } catch (Exception distNotFound) {
            try {
                String result = aziendaService.recuperoPassword(email);
                if(!result.isEmpty()) {
                    senderService.sendEmail(email, "Recupero Password", result);
                    return new ResponseEntity<>(1, HttpStatus.OK);
                }
            } catch (Exception aziendaNotFound) {
                try {
                    String result = adminService.recuperoPassword(email);
                    if(!result.isEmpty()) {
                        senderService.sendEmail(email, "Recupero Password", result);
                        return new ResponseEntity<>(1, HttpStatus.OK);
                    }
                } catch (Exception adminNotFound) {
                    return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
