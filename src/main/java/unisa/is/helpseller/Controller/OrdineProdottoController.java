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
    public ResponseEntity<OrdineProdotto> insert(@RequestBody OrdineProdotto ordProd) {
        try {
            ordineprodottoService.insert(ordProd);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<OrdineProdotto> update(@RequestBody OrdineProdotto ordProd) {
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
    
    @GetMapping("/findReportAnnuale/{anno}")
    public ResponseEntity<Integer> findReportAnnuale(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportAnnuale(anno);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/findReportAnnualeAzienda/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportAnnualeAzienda(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportAnnualeAzienda(anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    
    @GetMapping("findReportGennaio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportGennaio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("01", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportFebbraio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportFebbraio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("02", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportMarzo/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportMarzo(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("03", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportAprile/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportAprile(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("04", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportMaggio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportMaggio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("05", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportGiugno/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportGiugno(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("06", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportLuglio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportLuglio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("07", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportAgosto/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportAgosto(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("08", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportSettembre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportSettembre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("09", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportOttobre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportOttobre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("10", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportNovembre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportNovembre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("11", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportDicembre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportDicembre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("12", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("findReportGennaioGruppo/{anno}")
    public ResponseEntity<Integer> findReportGennaioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("01", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportFebbraioGruppo/{anno}")
    public ResponseEntity<Integer> findReportFebbraioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("02", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportMarzoGruppo/{anno}")
    public ResponseEntity<Integer> findReportMarzoGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("03", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportAprileGruppo/{anno}")
    public ResponseEntity<Integer> findReportAprileGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("04", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportMaggioGruppo/{anno}")
    public ResponseEntity<Integer> findReportMaggioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("05", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportGiugnoGruppo/{anno}")
    public ResponseEntity<Integer> findReportGiugnoGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("06", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportLuglioGruppo/{anno}")
    public ResponseEntity<Integer> findReportLuglioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("07", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportAgostoGruppo/{anno}")
    public ResponseEntity<Integer> findReportAgostoGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("08", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportSettembreGruppo/{anno}")
    public ResponseEntity<Integer> findReportSettembreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("09", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportOttobreGruppo/{anno}")
    public ResponseEntity<Integer> findReportOttobreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("10", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportNovembreGruppo/{anno}")
    public ResponseEntity<Integer> findReportNovembreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("11", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportDicembreGruppo/{anno}")
    public ResponseEntity<Integer> findReportDicembreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("12", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
