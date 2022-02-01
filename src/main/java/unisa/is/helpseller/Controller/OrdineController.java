package unisa.is.helpseller.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Entity.Ordine;
import unisa.is.helpseller.Model.OrdineModel;
import unisa.is.helpseller.Model.OrdineProdottoModel;
import unisa.is.helpseller.Service.DistributoreService;
import unisa.is.helpseller.Service.EmailSenderService;

/**
 * classe di mappatura dei servizi relativi ad Ordine affinché siano accessibili
 * dal frontend
 */
@RestController
@RequestMapping("/ordine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdineController {

    @Autowired
    private final OrdineService ordineService;

    @Autowired
    private DistributoreService distributoreService;

    @Autowired
    private OrdineProdottoController ordineProdottoController;

    @Autowired
    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    private EmailSenderService senderService = EmailSenderService.getInstance();

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     *
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<OrdineModel>> findAll() {
        try {
            List<Ordine> ordini = ordineService.findAll();
            List<OrdineModel> ordiniModel = new ArrayList<OrdineModel>();
            ordiniModel = ordini.stream().map(p -> {
                return new OrdineModel(p);
            }).collect(Collectors.toList());
            return new ResponseEntity<>(ordiniModel, HttpStatus.OK);
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
    public ResponseEntity<OrdineModel> findId(@PathVariable("id") int id) {
        try {
            Ordine ordine = ordineService.findId(id);
            OrdineModel o = new OrdineModel(ordine);
            return new ResponseEntity<>(o, HttpStatus.OK);
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
            int result = ordineService.deleteId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     *
     * @param model OrdineModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody OrdineModel model) {
        try {

            //Converto in entity e invio al database
            Ordine entity = new Ordine(model);
            int id = ordineService.insert(entity);

            //Controllo che l'invio al database sia andato a buon fine

            //Invio ordineprodotto al database
            List<OrdineProdottoModel> opmList = model.getOrdineProdotti();

            for (int i = 0; i < opmList.size(); i++) {
                opmList.get(i).setIdOrdine(id);
            }

            ordineProdottoController.insert(opmList);
            //Recupero il distributore e invio mail
            Distributore d = distributoreService.findId(entity.getIdDistributore());
            senderService.sendEmail(d.getEmail(), "Ordine confermato", "Il tuo ordine è stato confermato");
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Eccezione" + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'update di una entità presente nel DB
     *
     * @param ord OrdineModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody OrdineModel ord) {
        try {
            Ordine o = new Ordine(ord);
            int id = ordineService.update(o);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero degli ordini dato un distributore
     *
     * @param id del distributore
     * @return lista degli ordini recuperati
     */
    @GetMapping("/findOrdiniByDistributore/{id}")
    public ResponseEntity<List<OrdineModel>> findOrdiniByDistributore(@PathVariable("id") int id) {
        try {
            List<Ordine> ordini = ordineService.findOrdiniByDistributore(id);
            List<OrdineModel> ordiniModel = new ArrayList<OrdineModel>();
            if (ordini.size() > 0) {
                ordiniModel = ordini.stream().map(p -> {
                    return new OrdineModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(ordiniModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ordiniModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero degli ordini data un'azienda
     *
     * @param id id dell'azienda
     * @return lista degli ordini recuperati
     */
    @GetMapping("/findOrdiniByAzienda/{id}")
    public ResponseEntity<List<OrdineModel>> findOrdiniByAzienda(@PathVariable("id") int id) {
        try {
            List<Ordine> ordini = ordineService.findOrdiniByAzienda(id);
            List<OrdineModel> ordiniModel = new ArrayList<OrdineModel>();
            if (ordini.size() > 0) {
                ordiniModel = ordini.stream().map(p -> {
                    return new OrdineModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(ordiniModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ordiniModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
