package unisa.is.helpseller.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Service.ProdottoService;
import unisa.is.helpseller.Service.RaccomandazioneService;
import unisa.is.helpseller.Service.RecensioneService;


/**
 *
 * @author Alex
 * metodo che gestisce la selezione degli articoli da suggerire all'utente 
 */

@RestController
@RequestMapping("/sugg")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RaccomandazioneController {

    private final RaccomandazioneService suggService;
    
    @Autowired
    public RaccomandazioneController(RaccomandazioneService suggService) {this.suggService = suggService;}
    
    //dipendenza con ProdottoService perché perché richiesto per inviare i prodotti al frontEnd
    @Autowired
    private ProdottoService ps;
    @Autowired
    private RecensioneService ds;
    
    
    @GetMapping("/data")
    public void creaCsv() throws IOException{
        suggService.creaCsv();
    }
    
    //TO DO: ordinare i prodotti in output!
    @GetMapping("/l1")
    public ProdottoModel[] firstLayer() throws IOException{
        ProdottoModel[] array = suggService.firstLayer(ps);
        System.out.println(array);
        return array;
    }
    
    //TO DO: prendere in considerazione tutti gli item non solo l'ultimo
    @PostMapping("/l2")
    public ProdottoModel[] secondLayer(int id) throws IOException{
        ProdottoModel[] array = suggService.secondLayer(ds, ps, id);
        System.out.println(array);
        return array;
    }
}