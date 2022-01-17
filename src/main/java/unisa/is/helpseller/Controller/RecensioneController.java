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
@CrossOrigin("http://localhost:4200")
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
            if (recensioni.size() > 0) {
                recensioniModel = recensioni.stream().map(p -> {
                    return new RecensioneModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(recensioniModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(recensioniModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<RecensioneModel> findId(@PathVariable("id") int id) {
        try {
            Recensione recensione = recensioneService.findId(id);
            RecensioneModel r = new RecensioneModel(recensione);
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<RecensioneModel> deleteId(@PathVariable("id") int id) {
        try {
            recensioneService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<RecensioneModel> insert(RecensioneModel rec) {
        try {
            Recensione r = new Recensione(rec);
            recensioneService.insert(r);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<RecensioneModel> update(RecensioneModel rec) {
        try {
            Recensione r = new Recensione(rec);
            recensioneService.udpate(r);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
