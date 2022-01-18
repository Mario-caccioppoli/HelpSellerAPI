package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.OrdineService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Ordine;
import unisa.is.helpseller.Model.OrdineModel;

@RestController
@RequestMapping("/ordine")
@CrossOrigin("http://localhost:4200")
public class OrdineController {

    @Autowired
    private final OrdineService ordineService;

    @Autowired
    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OrdineModel>> findAll() {
        try {
            List<Ordine> ordini = ordineService.findAll();
            List<OrdineModel> ordiniModel = new ArrayList<OrdineModel>();
            ordiniModel = ordini.stream().map(p -> {
                return new OrdineModel(p);
            }).collect(Collectors.toList());
            return new ResponseEntity<>(ordiniModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<OrdineModel> findId(@PathVariable("id") int id) {
        try {
            Ordine ordine = ordineService.findId(id);
            if (!ordine.equals(null)) {
                OrdineModel o = new OrdineModel(ordine);
                return new ResponseEntity<>(o, HttpStatus.OK);
            } 
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = ordineService.deleteId(id);
            if(result > 0) {
               return new ResponseEntity<>(result, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(OrdineModel ord) {
        try {
            Ordine o = new Ordine(ord);
            int id = ordineService.insert(o);
            if(id > 0) {
               return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(OrdineModel ord) {
        try {
            Ordine o = new Ordine(ord);
            int id = ordineService.update(o);
            if(id > 0) {
               return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findOrdiniByDistributore/{id}")
    public ResponseEntity<List<OrdineModel>> findOrdiniByDistributore(@PathVariable("id") int id) {
        try {
            List<Ordine> ordini = ordineService.findOrdiniByDistributore(id);
            List<OrdineModel> ordiniModel = new ArrayList<OrdineModel>();
            if (ordini.size() > 0) {
                ordiniModel = ordini.stream().map(p -> {
                    return new OrdineModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(ordiniModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ordiniModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findOrdiniByAzienda/{id}")
    public ResponseEntity<List<OrdineModel>> findOrdiniByAzienda(@PathVariable("id") int id) {
        try {
            List<Ordine> ordini = ordineService.findOrdiniByAzienda(id);
            List<OrdineModel> ordiniModel = new ArrayList<OrdineModel>();
            if (ordini.size() > 0) {
                ordiniModel = ordini.stream().map(p -> {
                    return new OrdineModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(ordiniModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ordiniModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
