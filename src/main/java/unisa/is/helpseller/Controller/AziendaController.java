package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AziendaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Model.AziendaModel;

/**
 * classe di mappatura dei servizi relativi ad Azienda affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/azienda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AziendaController {

    @Autowired
    private final AziendaService aziendaService;
    
    @Autowired
    private FileController fileController;

    @Autowired
    public AziendaController(AziendaService aziendaService) {
        this.aziendaService = aziendaService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<AziendaModel>> findAll() {
        try {
            List<Azienda> aziende = aziendaService.findAll();
            List<AziendaModel> aziendeModel = new ArrayList<AziendaModel>();
                aziendeModel = aziende.stream().map(p -> {
                    return new AziendaModel(p);
                }).collect(Collectors.toList());
            
             for (int i = 0; i < aziendeModel.size(); i++) {
                    try {
                        byte[] imgBuf = fileController.getImageWithMediaType(
                                aziendeModel.get(i).getLogo());
                        
                        aziendeModel.get(i).setLogoBlob(imgBuf);
                    } catch (Exception cycle) {
                        System.out.println("ERRORE " + cycle);
                    } 
                }
                    
            return new ResponseEntity<>(aziendeModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB da restituire al frontend
     */
    @GetMapping("/findId/{id}")
    public ResponseEntity<AziendaModel> findId(@PathVariable("id") int id) {
        try {
            Azienda azienda = aziendaService.findId(id);
            AziendaModel a = new AziendaModel(azienda);
             return new ResponseEntity<>(a, HttpStatus.OK);
      
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = aziendaService.deleteId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
       
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param a AziendaModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody AziendaModel a) {
        try {
            Azienda azienda = new Azienda(a);
            int id = aziendaService.insert(azienda);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param a AziendaModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody AziendaModel a) {
        try {
            Azienda azienda = new Azienda(a);
            int id = aziendaService.update(azienda);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
           
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * metodo di ricerca dato il nome dell'azienda
     * @param name Stringa contenente il nome dell'azienda
     * @return  List<Azienda> lista di oggetti recuperati
     */
    @GetMapping("/findAziendaByNome/{name}")
    public ResponseEntity<List<AziendaModel>> findAziendeByNome(@PathVariable("name") String name) {
        try {
            List<Azienda> aziende = aziendaService.findAziendeByNome(name);
            List<AziendaModel> aziendeModel = new ArrayList<AziendaModel>();
            if (aziende.size() > 0) {
                aziendeModel = aziende.stream().map(p -> {
                    return new AziendaModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(aziendeModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(aziendeModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerca dato l'id del prodotto
     * @param id   variabile int contenente l'id del prodotto
     * @return  oggetto dell'azienda produttrice del prodotto
     */
    @GetMapping("/findAziendaByProdotto/{id}")
    public ResponseEntity<AziendaModel> findAziendaByProdotto(@PathVariable("id") int id) {
        try {
            Azienda azienda = aziendaService.findAziendaByProdotto(id);
            AziendaModel aziendaModel = new AziendaModel(azienda);
            return new ResponseEntity<>(aziendaModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
