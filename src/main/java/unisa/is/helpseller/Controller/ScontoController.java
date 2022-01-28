package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Sconto;
import unisa.is.helpseller.Model.ScontoModel;

/**
 * classe di mappatura dei servizi relativi a Sconto affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/sconto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScontoController {

    @Autowired
    private final ScontoService scontoService;

    @Autowired
    public ScontoController(ScontoService scontoService) {
        this.scontoService = scontoService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<ScontoModel>> findAll() {
        try {
            List<Sconto> sconti = scontoService.findAll();
            List<ScontoModel> scontiModel = new ArrayList<ScontoModel>();
            scontiModel = sconti.stream().map(p -> {
                return new ScontoModel(p);
            }).collect(Collectors.toList());
            return new ResponseEntity<>(scontiModel, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB da restituire al frontend
     */
    @GetMapping("/findId/{id}")
    public ResponseEntity<ScontoModel> findId(@PathVariable("id") int id) {
        try {
            Sconto sconto = scontoService.findId(id);
            ScontoModel s = new ScontoModel(sconto);
            return new ResponseEntity<>(s, HttpStatus.OK);
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
            int result = scontoService.deleteId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param sc ScontoModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody ScontoModel sc) {
        try {
            Sconto s = new Sconto(sc);
            int id = scontoService.insert(s);
            return new ResponseEntity<>(id, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param sc ScontoModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody ScontoModel sc) {
        try {
            Sconto s = new Sconto(sc);
            int id = scontoService.udpate(s);
            if (id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * metodo di ricerca data l'azienda
     * @param id dell'azienda
     * @return lista degli sconti recuperati
     */
    @GetMapping("/findScontiByAzienda/{id}")
    public ResponseEntity<List<ScontoModel>> findScontiByAzienda(@PathVariable("id") int id) {
        try {
            List<Sconto> sconti = scontoService.findScontiByAzienda(id);
            List<ScontoModel> scontiModel = new ArrayList<ScontoModel>();
            if (sconti.size() > 0) {
                scontiModel = sconti.stream().map(p -> {
                    return new ScontoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(scontiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(scontiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerca dato il tipo
     * @param tipo dello sconto
     * @return lista degli sconti recuperati
     */
    @GetMapping("/findScontiByTipo/{tipo}")
    public ResponseEntity<List<ScontoModel>> findScontiByTipo(@PathVariable("tipo") String tipo) {
        try {
            List<Sconto> sconti = scontoService.findScontiByTipo(tipo);
            List<ScontoModel> scontiModel = new ArrayList<ScontoModel>();
            if (sconti.size() > 0) {
                scontiModel = sconti.stream().map(p -> {
                    return new ScontoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(scontiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(scontiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerca dato il tipo e l'azienda
     * @param tipo
     * @param id_azienda
     * @return lista degli sconti recuperati
     */
    @GetMapping("findScontiAziendaByTipo/{tipo}/{id_azienda}")
    public ResponseEntity<List<ScontoModel>> findScontiAziendaByTipo(@PathVariable("tipo") String tipo, 
            @PathVariable("id_azienda") int id_azienda) {
        try {
            List<Sconto> sconti = scontoService.findScontiAziendaByTipo(tipo, id_azienda);
            if(!sconti.equals(null)) {
                List<ScontoModel> scontiModel = new ArrayList<ScontoModel>();
                scontiModel = sconti.stream().map(p -> {
                    return new ScontoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(scontiModel, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * metodo di ricerca dato il nome e l'azienda
     * @param nome_sconto
     * @param id dell'azienda
     * @return lista degli sconti recuperati
     */
    @GetMapping("findScontiByNomeInAzienda/{nome_sconto}/{id_azienda}")
    public ResponseEntity<List<ScontoModel>> findScontiByNomeInAzienda(@PathVariable("nome_sconto") String nome_sconto, 
            @PathVariable("id_azienda") int id) {
        try {
            List<Sconto> sconti = scontoService.findScontiByNomeInAzienda(nome_sconto, id);
            if(!sconti.equals(null)) {
                List<ScontoModel> scontiModel = new ArrayList<ScontoModel>();
                scontiModel = sconti.stream().map(p -> {
                    return new ScontoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(scontiModel, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
