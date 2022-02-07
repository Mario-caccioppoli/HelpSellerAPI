package unisa.is.helpseller.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Service.ProdottoService;
import unisa.is.helpseller.Service.RaccomandazioneService;
import unisa.is.helpseller.Service.RecensioneService;


/**
 * classe di mappatura dei servizi relativi il Raccomandation Engine affinché siano accessibili dal frontend
 */

@RestController
@RequestMapping("/sugg")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RaccomandazioneController {

    private final RaccomandazioneService suggService;
    
    @Autowired
    private FileController fileController;
    
    @Autowired
    public RaccomandazioneController(RaccomandazioneService suggService) {this.suggService = suggService;}
    
    //dipendenza con ProdottoService perché perché richiesto per inviare i prodotti al frontEnd
    @Autowired
    private ProdottoService ps;
    @Autowired
    private RecensioneService ds;

    /**
     * metodo per la generazione di un file .csv contenente le recensioni presenti nel db
     * @throws IOException caso in cui non viene trovato il file .exe
     */
    @GetMapping("/data")
    public void creaCsv() throws IOException{
        suggService.creaCsv();
    }

    /**
     * metodo per il recupero dei prodotti più popolari sulla piattaforma
     * @return vettore di oggetti prodottoModel
     * @throws IOException caso in cui non viene trovato il file .exe
     */
    @GetMapping("/l1")
    public ProdottoModel[] firstLayer() throws IOException{
        ProdottoModel[] prodottiModel = suggService.firstLayer(ps);
         for (int i = 0; i < prodottiModel.length; i++) {
                try {
                    byte[] imgBuf = fileController.getImageWithMediaType(prodottiModel[i].getImmagine());
                    prodottiModel[i].setImmagineBlob(imgBuf);
                } catch (Exception cycle) {
                    System.out.println("ERRORE " + cycle);
                }
            }
        return prodottiModel;
    }

    /**
     * metodo per il recupero dei prodotti da suggeerire all'utente
     * @param id dell'utente che sta navigando
     * @return vettore di model contente i prodotti da suggerire
     * @throws IOException caso in cui non viene trovato il file .exe
     */
    @GetMapping("/l2/{id}")
    public ProdottoModel[] secondLayer(@PathVariable("id") int idDistributore) throws IOException{
        ProdottoModel[] prodottiModel = suggService.secondLayer(ds, ps, idDistributore);
        for (int i = 0; i < prodottiModel.length; i++) {
                try {
                    byte[] imgBuf = fileController.getImageWithMediaType(prodottiModel[i].getImmagine());
                    prodottiModel[i].setImmagineBlob(imgBuf);
                } catch (Exception cycle) {
                    System.out.println("ERRORE " + cycle);
                }
            }
        return prodottiModel;
    }
}