package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.TrasportoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Trasporto;
import unisa.is.helpseller.Model.TrasportoModel;

/**
 * classe di mappatura dei servizi relativi a Trasporto affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/trasporto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrasportoController {

    @Autowired
    private final TrasportoService trasportoService;

    @Autowired
    public TrasportoController(TrasportoService trasportoService) {
        this.trasportoService = trasportoService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<TrasportoModel>> findAll() {
        try {
            List<Trasporto> trasporti = trasportoService.findAll();
            List<TrasportoModel> trasportiModel = new ArrayList<TrasportoModel>();
                trasportiModel = trasporti.stream().map(p -> {
                    return new TrasportoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(trasportiModel, HttpStatus.OK);
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
    public ResponseEntity<TrasportoModel> findId(@PathVariable("id") int id) {
        try {
            Trasporto trasporto = trasportoService.findId(id);
                TrasportoModel t = new TrasportoModel(trasporto);
                return new ResponseEntity<>(t, HttpStatus.OK);
           
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
            int result = trasportoService.deleteId(id);
                return new ResponseEntity<>(result, HttpStatus.OK);
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param tr TrasportoModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody TrasportoModel tr) {
        try {
            Trasporto t = new Trasporto(tr);
            int id = trasportoService.insert(t);
            return new ResponseEntity<>(id, HttpStatus.OK);
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param tr TrasportoModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody TrasportoModel tr) {
        try {
            Trasporto t = new Trasporto(tr);
            int id = trasportoService.udpate(t);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
