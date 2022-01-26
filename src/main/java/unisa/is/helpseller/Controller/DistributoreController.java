package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DistributoreService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Model.DistributoreModel;

/**
 * classe di mappatura dei servizi relativi a Distributore affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/distributore")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistributoreController {

    @Autowired
    private final DistributoreService distributoreService;

    @Autowired
    public DistributoreController(DistributoreService distributoreService) {
        this.distributoreService = distributoreService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<DistributoreModel>> findAll() {
        try {
            List<Distributore> distributori = distributoreService.findAll();
            List<DistributoreModel> distributoriModel = new ArrayList<DistributoreModel>();
                distributoriModel = distributori.stream().map(p -> {
                    return new DistributoreModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(distributoriModel, HttpStatus.OK);
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
    public ResponseEntity<DistributoreModel> findId(@PathVariable("id") int id) {
        try {
            Distributore distributore = distributoreService.findId(id);
            DistributoreModel d = new DistributoreModel(distributore);
            return new ResponseEntity<>(d, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = distributoreService.deleteId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param d Distributore oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody DistributoreModel d) {
        try {
            Distributore distributore = new Distributore(d);
            int id = distributoreService.insert(distributore);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param d Distributore oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody DistributoreModel d) {
        try {
            Distributore distributore = new Distributore(d);
            int id = distributoreService.update(distributore);
            return new ResponseEntity<Integer>(id, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
