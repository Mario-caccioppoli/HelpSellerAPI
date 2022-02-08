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

/**
 * classe di mappatura dei servizi relativi ad OrdineProdotto affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/ordineprodotto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdineProdottoController {

    @Autowired
    private final OrdineProdottoService ordineprodottoService;

    @Autowired
    private final RecensioneService recensioneService;
    
    @Autowired
    private FileController fileController;

    @Autowired
    public OrdineProdottoController(OrdineProdottoService ordineprodottoService, RecensioneService recensioneService) {
        this.ordineprodottoService = ordineprodottoService;
        this.recensioneService = recensioneService;
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param int id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    @DeleteMapping("/deleteId/{idOrdine}/{idProdotto}")
    public ResponseEntity<Integer> deleteId(@PathVariable("idOrdine") int idOrdine, @PathVariable("idProdotto") int idProdotto) {
        try {
            OrdineProdotto ordProd = new OrdineProdotto();
            ordProd.setIdOrdine(idOrdine);
            ordProd.setIdProdotto(idProdotto);
            int result = ordineprodottoService.deleteId(ordProd);
                return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param opList OrdineProdottoModel oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<List<Integer>> insert(@RequestBody List<OrdineProdottoModel> opList) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            for(OrdineProdottoModel opm : opList) {
                OrdineProdotto ordProd = new OrdineProdotto(opm);
                int resp = ordineprodottoService.insert(ordProd);
                result.add(resp);  
            }
        } catch (Exception ex) {
            System.out.println("Not inserted");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param opModel OrdineProdottoModel oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody OrdineProdottoModel opModel) {
        try {
            OrdineProdotto op = new OrdineProdotto(opModel);
            int result = ordineprodottoService.udpate(op);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * metodo di ricerca dato l'id di un ordine
     * @param id dell'ordine
     * @return lista contenente le entità OrdineProdotto recuperate
     */
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
                        RecensioneModel rBuf = new RecensioneModel(r);
                        rmList.add(rBuf);
                    } //END RECENSIONI FOR

                    ProdottoModel pBuf = new ProdottoModel(pList.get(i));
                    pBuf.setRecensioni(rmList);
                                        
                    try {
                        byte[] imgBuf = fileController.getImageWithMediaType(pBuf.getImmagine());
                        pBuf.setImmagineBlob(imgBuf);
                    } catch (Exception cycle) {
                        System.out.println("ERRORE " + cycle);
                    }
                    

                    OrdineProdottoModel opmBuf = new OrdineProdottoModel(
                            opList.get(i).getIdOrdine(), opList.get(i).getQuantitaOrdine(),
                            opList.get(i).getPrezzoUnitario(), pBuf);

                    opmList.add(opmBuf);
                } //END RIEMPIMENTO FOR

                if (!opmList.isEmpty()) {
                    return new ResponseEntity<>(opmList, HttpStatus.OK);
                } //END RETURN IF    
            }  //END RIEMPIMENTO IF

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } //END CATCH
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    } //END METODO

    /**
     * metodo per il report di un anno dato in input
     * @param anno intero dell'anno
     * @return somma complessiva del valore degli ordini dell'anno
     */
    @GetMapping("/findReportAnnuale")
    public ResponseEntity<ArrayList<ArrayList<Integer>>> findReportAnnuale() {
        try {
            List<Integer> anni = ordineprodottoService.findAnniOrdini();
            ArrayList<ArrayList<Integer>> resultTable = new ArrayList<ArrayList<Integer>>();
            for(Integer anno : anni) {
                Integer reportSum = ordineprodottoService.findReportAnnuale(anno);
                if(reportSum != null) {
                    ArrayList<Integer> buf = new ArrayList<Integer>();
                    buf.add(anno);
                    buf.add(reportSum);
                    resultTable.add(buf);
                }
            }
            return new ResponseEntity<>(resultTable, HttpStatus.OK);
          
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * metodo per il report di un anno di una azienda
     * @param anno intero dell'anno, l'id dell'azienda
     * @return somma complessiva del valore degli ordini dell'anno
     */
    @GetMapping("/findReportAnnualeAzienda/{id_azienda}")
    public ResponseEntity<ArrayList<ArrayList<Integer>>> findReportAnnualeAzienda(@PathVariable("id_azienda") Integer id) {
        try {
            List<Integer> anni = ordineprodottoService.findAnniOrdini();
            ArrayList<ArrayList<Integer>> resultTable = new ArrayList<ArrayList<Integer>>();
            for(Integer anno : anni) {
                Integer reportSum = ordineprodottoService.findReportAnnualeAzienda(anno, id);
                if(reportSum != null) {
                    ArrayList<Integer> buf = new ArrayList<Integer>();
                    buf.add(anno);
                    buf.add(reportSum);
                    resultTable.add(buf);
                }
            }
            return new ResponseEntity<>(resultTable, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    /**
     * metodo per il report di un mese di una azienda
     * @param anno intero del mese, l'anno e l'id dell'zienda
     * @return somma complessiva del valore degli ordini
     */
    @GetMapping("findReportMensileAzienda/{anno}/{id_azienda}")
    public ResponseEntity<Integer[]> findReportMensile(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        Integer mensilita[] = new Integer[12]; 
        for(Integer i = 1; i < 13; i++) {
            try {
                if(i < 10) {
                    Integer mese = ordineprodottoService.findReportMensile("0" + i.toString() , anno, id);
                    mensilita[i-1] = mese;
                } else {
                    Integer mese = ordineprodottoService.findReportMensile(i.toString(), anno, id);
                    mensilita[i-1] = mese;
                }
                
            } catch (Exception ex) {
                System.out.println("Null passed");
            }
        } //END FOR
        
        for(int i = 0; i < 12; i++) {
            if(mensilita[i] == null) {
                mensilita[i] = 0;
            }
        }
        return new ResponseEntity<>(mensilita, HttpStatus.OK);
    }

    /**
     * metodo per il report di un mese
     * @param anno intero del mese e dell'anno
     * @return somma complessiva del valore degli ordini del mese
     */
    @GetMapping("findReportMensileGruppo/{anno}")
    public ResponseEntity<Integer[]> findReportMensileGruppo(@PathVariable("anno") Integer anno) {
        Integer mensilita[] = new Integer[12]; 
        for(Integer i = 1; i < 13; i++) {
            try {
                if(i < 10) {
                    Integer mese = ordineprodottoService.findReportMensileGruppo("0" + i.toString() , anno);
                    mensilita[i-1] = mese;
                } else {
                    Integer mese = ordineprodottoService.findReportMensileGruppo(i.toString(), anno);
                    mensilita[i-1] = mese;
                }
                
            } catch (Exception ex) {
                System.out.println("Null passed");
            }
        } //END FOR
        
        for(int i = 0; i < 12; i++) {
            if(mensilita[i] == null) {
                mensilita[i] = 0;
            }
        }
        return new ResponseEntity<>(mensilita, HttpStatus.OK);
    }
    
}
