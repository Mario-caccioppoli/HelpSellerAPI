package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.RecensioneService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Recensione;
import unisa.is.helpseller.Model.RecensioneModel;

/**
 * classe di mappatura dei servizi relativi a Recensione affinché siano
 * accessibili dal frontend
 */
@RestController
@RequestMapping("/recensione")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecensioneController {

    @Autowired
    private final RecensioneService recensioneService;

    @Autowired
    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     *
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<RecensioneModel>> findAll() {
        try {
            List<Recensione> recensioni = recensioneService.findAll();
            List<RecensioneModel> recensioniModel = new ArrayList<RecensioneModel>();
            recensioniModel = recensioni.stream().map(p -> {
                return new RecensioneModel(p);
            }).collect(Collectors.toList());
            return new ResponseEntity<>(recensioniModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     *
     * @param id intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB da restituire al frontend
     */
    @GetMapping("/findId/{id}")
    public ResponseEntity<RecensioneModel> findId(@PathVariable("id") int id) {
        try {
            Recensione recensione = recensioneService.findId(id);
            RecensioneModel r = new RecensioneModel(recensione);
            return new ResponseEntity<>(r, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     *
     * @param id id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = recensioneService.deleteId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     *
     * @param rec RecensioneModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody RecensioneModel rec) {
        try {
            Recensione r = new Recensione(rec);
            int id = recensioneService.insert(r);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'update di una entità presente nel DB
     *
     * @param rec RecensioneModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody RecensioneModel rec) {
        try {
            Recensione r = new Recensione(rec);
            int id = recensioneService.udpate(r);
            if (id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
