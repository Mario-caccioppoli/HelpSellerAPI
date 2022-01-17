package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ScontoProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Entity.Sconto;
import unisa.is.helpseller.Entity.ScontoProdotto;
import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Model.ScontoModel;
import unisa.is.helpseller.Model.ScontoProdottoModel;

@RestController
@RequestMapping("/scontoprodotto")
@CrossOrigin("http://localhost:4200")
public class ScontoProdottoController {

    @Autowired
    private final ScontoProdottoService scontoProdottoService;

    @Autowired
    public ScontoProdottoController(ScontoProdottoService scontoProdottoService) {
        this.scontoProdottoService = scontoProdottoService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ScontoProdotto>> findAll() {
        try {
            List<ScontoProdotto> scontoProdotti = scontoProdottoService.findAll();
            return new ResponseEntity<>(scontoProdotti, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findBySconto/{id}")
    public ResponseEntity<ScontoProdotto> findBySconto(@PathVariable("id") int id) {
        try {
            ScontoProdotto scontoProdotto = scontoProdottoService.findBySconto(id);
            return new ResponseEntity<>(scontoProdotto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByProdotto/{id}")
    public ResponseEntity<ScontoProdotto> findByProdotto(@PathVariable("id") int id) {
        try {
            ScontoProdotto scontoProdotto = scontoProdottoService.findByProdotto(id);
            return new ResponseEntity<>(scontoProdotto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<ScontoProdotto> deleteId(@PathVariable("id") int id) {
        try {
            scontoProdottoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ScontoProdotto> insert(ScontoProdotto scontoProd) {
        try {
            scontoProdottoService.insert(scontoProd);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ScontoProdotto> update(ScontoProdotto updated, ScontoProdotto old) {
        try {
            scontoProdottoService.udpate(updated, old);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiScontatiAzienda/{name}/{id}")
    public ResponseEntity<List<ScontoProdottoModel>> findProdottiScontatiAzienda(@PathVariable("name") String name, @PathVariable("id") int id) {
        try {
            List<Object[]> objList = scontoProdottoService.findProdottiScontatiAzienda(name, id);
            List<ScontoProdottoModel> listModel = new ArrayList<ScontoProdottoModel>();
            System.out.println("TEST 1");
            for (Object[] obj : objList) {
                Prodotto pBuf = (Prodotto) obj[0];
                Sconto sBuf = (Sconto) obj[1];
                System.out.println("TEST 2");
                ProdottoModel pmBuf = new ProdottoModel(pBuf.getId(), 
                        pBuf.getNomeProdotto(), pBuf.getPrezzo(), pBuf.getDescrizione(),
                pBuf.getQuantita(), pBuf.getImmagine(), pBuf.getQuantitaMinima(), pBuf.getPeso(),
                pBuf.getVolume(), pBuf.getIdAzienda(), null, null);
                System.out.println("TEST 3");
                ScontoModel smBuf = new ScontoModel(sBuf.getId(), sBuf.getPercentuale(),
                sBuf.getDataInizio(), sBuf.getDataFine(), sBuf.getTipo(), sBuf.getQuantita(),
                sBuf.getIdAzienda(), null);
                System.out.println("TEST 4");
                ScontoProdottoModel spmBuf = new ScontoProdottoModel(pmBuf, smBuf);
                System.out.println("TEST 5");
                listModel.add(spmBuf);
                System.out.println("TEST 6");
            }
            System.out.println("TEST 7");    
            return new ResponseEntity<>(listModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
