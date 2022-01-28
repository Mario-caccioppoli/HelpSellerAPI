package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ProdottoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Model.ProdottoModel;

/**
 * classe di mappatura dei servizi relativi ad Prodotto affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/prodotto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdottoController {

    @Autowired
    private final ProdottoService prodottoService;

    @Autowired
    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Amministratore> lista di oggetti entity
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<ProdottoModel>> findAll() {
        try {
            List<Prodotto> prodotti = prodottoService.findAll();
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            prodottiModel = prodotti.stream().map(p -> {
                return new ProdottoModel(p);
            }).collect(Collectors.toList());
            return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    @GetMapping("/findId/{id}")
    public ResponseEntity<ProdottoModel> findId(@PathVariable("id") int id) {
        try {
            Prodotto prodotto = prodottoService.findId(id);
                ProdottoModel p = new ProdottoModel(prodotto);
                return new ResponseEntity<>(p, HttpStatus.OK);

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
            int result = prodottoService.deleteId(id);
                return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param prod ProdottoModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody ProdottoModel prod) {
        try {
            Prodotto p = new Prodotto(prod);
            int id = prodottoService.insert(p);
            return new ResponseEntity<>(id, HttpStatus.OK);
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param prod ProdottoModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody ProdottoModel prod) {
        try {
            Prodotto p = new Prodotto(prod);
            int id = prodottoService.udpate(p);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * metodo di ricerca dei prodotti dato l'id dell'azienda
     * @param id dell'azienda
     * @return lista di prodotti recuperati
     */
    @GetMapping("/findProdottiByAzienda/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByAzienda(@PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByAzienda(id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerca dei prodotti dato il nome
     * @param name stringa contenente il nome dell'azienda
     * @return lista dei prodotti recuperati
     */
    @GetMapping("/findProdottiByNome/{name}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByNome(@PathVariable("name") String name) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByNome(name);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerda di prodotti dato il nome e l'id dellazienda
     * @param name nome del prodotto
     * @param id id dell'azienda
     * @return lista dei prodotti recuperati
     */
    @GetMapping("/findProdottiByNomeInAzienda/{name}/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByNomeInAzienda(@PathVariable("name") String name, @PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByNomeInAzienda(name, id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerca dato l'id di un ordine
     * @param id dell'ordine
     * @return lista di prodotti recuperati
     */
    @GetMapping("/findProdottiInOrdine/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiInOrdine(@PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiInOrdine(id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerda dato l'id di uno sconto
     * @param id dello sconto
     * @return lista dei prodotti recuperati
     */
    @GetMapping("/findProdottiBySconto/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiInSconto(@PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiBySconto(id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo di ricerca dato l'id del prodotto e dell'azienda
     * @param id_prodotto id del prodotto
     * @param id_azienda id dell'azienda
     * @return lista contenente i prodotti recuperati
     */
    @GetMapping("/findProdottiByIdInAzienda/{id_prodotto}/{id_azienda}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByIdInAzienda(@PathVariable("id_prodotto") int id_prodotto, 
            @PathVariable("id_azienda") int id_azienda) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByIdInAzienda(id_prodotto, id_azienda);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
