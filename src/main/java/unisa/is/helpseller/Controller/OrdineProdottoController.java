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
    public ResponseEntity<List<OrdineProdottoModel>> findAll() {
        try {
            List<OrdineProdotto> ordineProdotti = ordineprodottoService.findAll();
            if(!ordineProdotti.isEmpty()) {
                List<OrdineProdottoModel> opmList = new ArrayList<OrdineProdottoModel>();
                for(OrdineProdotto op : ordineProdotti) {
                    OrdineProdottoModel modelBuf = new OrdineProdottoModel();
                }
                return new ResponseEntity<>(HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    public ResponseEntity<Integer> deleteId(@PathVariable("idOrdine") int idOrdine, @PathVariable("idProdotto") int idProdotto) {
        try {
            OrdineProdotto ordProd = new OrdineProdotto();
            ordProd.setIdOrdine(idOrdine);
            ordProd.setIdProdotto(idProdotto);
            int result = ordineprodottoService.deleteId(ordProd);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } 
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody OrdineProdotto ordProd) {
        try {
            int result = ordineprodottoService.insert(ordProd);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody OrdineProdotto ordProd) {
        try {
            int result = ordineprodottoService.udpate(ordProd);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

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
    
    @GetMapping("/findReportAnnuale/{anno}")
    public ResponseEntity<Integer> findReportAnnuale(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportAnnuale(anno);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/findReportAnnualeAzienda/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportAnnualeAzienda(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportAnnualeAzienda(anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        
    }
    
    @GetMapping("findReportGennaio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportGennaio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("01", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportFebbraio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportFebbraio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("02", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportMarzo/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportMarzo(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("03", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportAprile/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportAprile(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("04", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportMaggio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportMaggio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("05", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportGiugno/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportGiugno(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("06", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportLuglio/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportLuglio(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("07", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportAgosto/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportAgosto(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("08", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportSettembre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportSettembre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("09", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportOttobre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportOttobre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("10", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportNovembre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportNovembre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("11", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
        @GetMapping("findReportDicembre/{anno}/{id_azienda}")
    public ResponseEntity<Integer> findReportDicembre(@PathVariable("anno") Integer anno, @PathVariable("id_azienda") Integer id) {
        try {
            Integer report = ordineprodottoService.findReportMensile("12", anno, id);
            if (!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("findReportGennaioGruppo/{anno}")
    public ResponseEntity<Integer> findReportGennaioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("01", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportFebbraioGruppo/{anno}")
    public ResponseEntity<Integer> findReportFebbraioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("02", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportMarzoGruppo/{anno}")
    public ResponseEntity<Integer> findReportMarzoGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("03", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportAprileGruppo/{anno}")
    public ResponseEntity<Integer> findReportAprileGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("04", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportMaggioGruppo/{anno}")
    public ResponseEntity<Integer> findReportMaggioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("05", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportGiugnoGruppo/{anno}")
    public ResponseEntity<Integer> findReportGiugnoGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("06", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportLuglioGruppo/{anno}")
    public ResponseEntity<Integer> findReportLuglioGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("07", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportAgostoGruppo/{anno}")
    public ResponseEntity<Integer> findReportAgostoGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("08", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportSettembreGruppo/{anno}")
    public ResponseEntity<Integer> findReportSettembreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("09", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportOttobreGruppo/{anno}")
    public ResponseEntity<Integer> findReportOttobreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("10", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportNovembreGruppo/{anno}")
    public ResponseEntity<Integer> findReportNovembreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("11", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
    
     @GetMapping("findReportDicembreGruppo/{anno}")
    public ResponseEntity<Integer> findReportDicembreGruppo(@PathVariable("anno") Integer anno) {
        try {
            Integer report = ordineprodottoService.findReportMensileGruppo("12", anno);
            if(!report.equals(null)) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
    }
}
