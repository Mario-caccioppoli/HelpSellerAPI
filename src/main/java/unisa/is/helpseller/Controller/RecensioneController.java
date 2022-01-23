package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.RecensioneService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Recensione;
import unisa.is.helpseller.Model.RecensioneModel;

@RestController
@RequestMapping("/recensione")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecensioneController {

    @Autowired
    private final RecensioneService recensioneService;

    @Autowired
    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RecensioneModel>> findAll() {
        try {
            List<Recensione> recensioni = recensioneService.findAll();
            List<RecensioneModel> recensioniModel = new ArrayList<RecensioneModel>();
                recensioniModel = recensioni.stream().map(p -> {
                    return new RecensioneModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(recensioniModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<RecensioneModel> findId(@PathVariable("id") int id) {
        try {
            Recensione recensione = recensioneService.findId(id);
            if(!recensione.equals(null)) {
                RecensioneModel r = new RecensioneModel(recensione);
                return new ResponseEntity<>(r, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = recensioneService.deleteId(id);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody RecensioneModel rec) {
        try {
            Recensione r = new Recensione(rec);
            int id = recensioneService.insert(r);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody RecensioneModel rec) {
        try {
            Recensione r = new Recensione(rec);
            int id = recensioneService.udpate(r);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    /* DA AGGIORNARE
    @GetMapping("/findRecensioniByProdotto/{id}")
    public ResponseEntity<List<RecensioneModel>> findRecensioniByProdotto(@PathVariable("id") int id) {
        try {
            List<Recensione> rList = recensioneService.findRecensioniByProdotto(id);
            List<RecensioneModel> modelList = new ArrayList<RecensioneModel>();
            
            for(int i = 0; i < rList.size(); i++) {
                RecensioneModel rBuf = new RecensioneModel(rList.get(i).getId(),
                rList.get(i).getTesto(), rList.get(i).getVoto(), rList.get(i).getData(),
                rList.get(i).getIdProdotto(), rList.get(i).getIdDistributore());
                modelList.add(rBuf);
            }
            
            return new ResponseEntity<>(modelList, HttpStatus.OK);
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
}
