package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.ScontoProdotto;
import unisa.is.helpseller.Model.ScontoProdottoModel;
import unisa.is.helpseller.Service.ProdottoService;
import unisa.is.helpseller.Service.ScontoService;

/**
 * classe di mappatura dei servizi relativi a ScontoProdotto affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/scontoprodotto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScontoProdottoController {

    @Autowired
    private final ScontoProdottoService scontoProdottoService;
    @Autowired
    private final ScontoService scontoService;
    @Autowired
    private final ProdottoService prodottoService;

    @Autowired
    public ScontoProdottoController(
            ScontoProdottoService scontoProdottoService,
            ScontoService scontoService,
            ProdottoService prodottoService) {
        this.scontoProdottoService = scontoProdottoService;
        this.scontoService = scontoService;
        this.prodottoService = prodottoService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return lista di oggetti delle entity da passare al frontEnd
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<ScontoProdottoModel>> findAllScontoProdotto() {
        try {
            ScontoController scontoController = new ScontoController(scontoService);
            ProdottoController prodottoController = new ProdottoController(prodottoService);
            List<ScontoProdotto> scontoProdotti = scontoProdottoService.findAllScontoProdotto();
            List<ScontoProdottoModel> modelList = new ArrayList<ScontoProdottoModel>();

            for (ScontoProdotto sp : scontoProdotti) {
                ScontoProdottoModel modelBuf = new ScontoProdottoModel(
                        prodottoController.findId(sp.getIdProdotto()).getBody(),
                        scontoController.findId(sp.getIdSconto()).getBody());

                modelList.add(modelBuf);
            }
            return new ResponseEntity<>(modelList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB da restituire al frontend
     */
    /*
    @GetMapping("/findBySconto/{id}")
    public ResponseEntity<List<ScontoProdottoModel>> findBySconto(@PathVariable("id") int id) {
        try {
            ScontoController scontoController = new ScontoController(scontoService);
            ProdottoController prodottoController = new ProdottoController(prodottoService);
            List<ScontoProdotto> scontoProdotti = scontoProdottoService.findBySconto(id);
            List<ScontoProdottoModel> modelList = new ArrayList<ScontoProdottoModel>();

            for (ScontoProdotto sp : scontoProdotti) {

                ScontoProdottoModel modelBuf = new ScontoProdottoModel(
                        prodottoController.findId(sp.getIdProdotto()).getBody(),
                        scontoController.findId(sp.getIdSconto()).getBody());

                modelList.add(modelBuf);
            }

            return new ResponseEntity<>(modelList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB da restituire al frontend
     */
    /*
    @GetMapping("/findByProdotto/{id}")
    public ResponseEntity<List<ScontoProdottoModel>> findByProdotto(@PathVariable("id") int id) {
        try {
            ScontoController scontoController = new ScontoController(scontoService);
            ProdottoController prodottoController = new ProdottoController(prodottoService);
            List<ScontoProdotto> scontoProdotti = scontoProdottoService.findByProdotto(id);
            List<ScontoProdottoModel> modelList = new ArrayList<ScontoProdottoModel>();

            for (ScontoProdotto sp : scontoProdotti) {

                ScontoProdottoModel modelBuf = new ScontoProdottoModel(
                        prodottoController.findId(sp.getIdProdotto()).getBody(),
                        scontoController.findId(sp.getIdSconto()).getBody());

                modelList.add(modelBuf);
            }

            return new ResponseEntity<>(modelList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
    

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    @DeleteMapping("/deleteId/{id_sconto}")
    public ResponseEntity<Integer> deleteId(
            @PathVariable("id_sconto") int id_sconto) {

        try {
            int result = scontoProdottoService.deleteId(id_sconto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param ScontoProdotto oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert/{id_prodotto}/{id_sconto}")
    public ResponseEntity<Integer> insert(
            @PathVariable("id_prodotto") int id_prodotto,
            @PathVariable("id_sconto") int id_sconto) {

        try {
            Integer result = scontoProdottoService.insert(id_sconto, id_prodotto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody List<ScontoProdottoModel> spList) {
        try {
            ScontoProdotto old = new ScontoProdotto(
            spList.get(0).getProdotto().getId(),
            spList.get(0).getSconto().getId());
            
            ScontoProdotto updated = new ScontoProdotto(
            spList.get(1).getProdotto().getId(),
            spList.get(1).getSconto().getId());
            int result = scontoProdottoService.udpate(updated, old);
            if (result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
*/

}
