package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineProdottoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.OrdineProdotto;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Entity.Recensione;
import unisa.is.helpseller.Model.OrdineProdottoModel;
import unisa.is.helpseller.Model.ProdottoModel;
import unisa.is.helpseller.Model.RecensioneModel;
import unisa.is.helpseller.Service.RecensioneService;

@RestController
@RequestMapping("/ordineprodotto")
@CrossOrigin("http://localhost:4200")
public class OrdineProdottoController {

    @Autowired
    private final OrdineProdottoService ordineprodottoService;

    @Autowired
    private final RecensioneService recensioneService;

    @Autowired
    public OrdineProdottoController(OrdineProdottoService ordineprodottoService, RecensioneService recensioneService) {
        this.ordineprodottoService = ordineprodottoService;
        this.recensioneService = recensioneService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OrdineProdotto>> findAll() {
        try {
            List<OrdineProdotto> ordineProdotti = ordineprodottoService.findAll();
            return new ResponseEntity<>(ordineProdotti, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{idOrdine}/{idProdotto}")
    public ResponseEntity<OrdineProdotto> findId(@PathVariable("idOrdine") int idOrdine, @PathVariable("idProdotto") int idProdotto) {
        try {
            OrdineProdotto ordProd = new OrdineProdotto();
            ordProd.setIdOrdine(idOrdine);
            ordProd.setIdProdotto(idProdotto);
            System.out.println(ordProd);
            OrdineProdotto ordineProdotto = ordineprodottoService.findId(ordProd);
            return new ResponseEntity<>(ordineProdotto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{idOrdine}/{idProdotto}")
    public ResponseEntity<OrdineProdotto> deleteId(@PathVariable("idOrdine") int idOrdine, @PathVariable("idProdotto") int idProdotto) {
        try {
            OrdineProdotto ordProd = new OrdineProdotto();
            ordProd.setIdOrdine(idOrdine);
            ordProd.setIdProdotto(idProdotto);
            ordineprodottoService.deleteId(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<OrdineProdotto> insert(OrdineProdotto ordProd) {
        try {
            ordineprodottoService.insert(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<OrdineProdotto> update(OrdineProdotto ordProd) {
        try {
            ordineprodottoService.udpate(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @GetMapping("/findDettagliOrdine/{id}")
    public ResponseEntity<List<OrdineProdottoModel>> findDettagliOrdine(@PathVariable("id") int id) {
        try {
            List<OrdineProdotto> opList = ordineprodottoService.findDettagliOrdine(id);
            List<Prodotto> pList = ordineprodottoService.findDettagliProdotto(id);
            List<OrdineProdottoModel> opmList = new ArrayList<OrdineProdottoModel>();
            List<RecensioneModel> rmList = new ArrayList<RecensioneModel>();

            if (opList.size() == pList.size()) {
                for (int i = 0; i < opList.size(); i++) {

                    List<Recensione> rList = recensioneService.findRecensioniByProdotto(pList.get(i).getId());

                    for (Recensione r : rList) {
                        RecensioneModel rBuf = new RecensioneModel(rList.get(i).getId(),
                                rList.get(i).getTesto(), rList.get(i).getVoto(), rList.get(i).getData(),
                                rList.get(i).getIdProdotto(), rList.get(i).getIdDistributore());
                        rmList.add(rBuf);
                    }

                    ProdottoModel pBuf = new ProdottoModel(pList.get(i).getId(),
                            pList.get(i).getNomeProdotto((int i = 0; i < opList.size(); i++) {

                    List<Recensione> rList = recensioneService.findRecensioniByProdotto(pList.get(i).getId());

                    for (Recensione r : rList) {
                        RecensioneModel rBuf = new RecensioneModel(rList.get(i).getId(),
                                rList.get(i).getTesto(), rList.get(i).getVoto(), rList.get(i).getData(),
                                rList.get(i).getIdProdotto(), rList.get(i).getIdDistributore());
                        rmList.add(rBuf);
                    }

                    ProdottoModel pBuf = new ProdottoModel(pList.get), pList.get(i).getPrezzo(),
                            pList.get(i).getDescrizione(), pList.get(i).getQuantita(),
                            pList.get(i).getImmagine(), pList.get(i).getQuantitaMinima(),
                            pList.get(i).getPeso(), pList.get(i).getVolume(), pList.get(i).getIdAzienda(),
                            rmList, null);

                    OrdineProdottoModel opmBuf = new OrdineProdottoModel(
                            opList.get(i).getIdOrdine(), opList.get(i).getQuantitaOrdine(),
                            opList.get(i).getPrezzoUnitario(), pBuf);

                    opmList.add(opmBuf);
                }
                return new ResponseEntity<>(opmList, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    /*
    @GetMapping("/findDettagliOrdineProdotto/{id}")
    public ResponseEntity<List<Object[]>> findDettagliOrdineProdotto(@PathVariable("id") int id) {
        List<Object[]>
        
    }*/
}
