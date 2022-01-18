package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.TrasportoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Trasporto;
import unisa.is.helpseller.Model.TrasportoModel;

@RestController
@RequestMapping("/trasporto")
@CrossOrigin("http://localhost:4200")
public class TrasportoController {

    @Autowired
    private final TrasportoService trasportoService;

    @Autowired
    public TrasportoController(TrasportoService trasportoService) {
        this.trasportoService = trasportoService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TrasportoModel>> findAll() {
        try {
            List<Trasporto> trasporti = trasportoService.findAll();
            List<TrasportoModel> trasportiModel = new ArrayList<TrasportoModel>();
                trasportiModel = trasporti.stream().map(p -> {
                    return new TrasportoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(trasportiModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<TrasportoModel> findId(@PathVariable("id") int id) {
        try {
            Trasporto trasporto = trasportoService.findId(id);
            if(!trasporto.equals(null)) {
                TrasportoModel t = new TrasportoModel(trasporto);
                return new ResponseEntity<>(t, HttpStatus.OK);
            }
           
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = trasportoService.deleteId(id);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody TrasportoModel tr) {
        try {
            Trasporto t = new Trasporto(tr);
            int id = trasportoService.insert(t);
            if(id > 0) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody TrasportoModel tr) {
        try {
            Trasporto t = new Trasporto(tr);
            int id = trasportoService.udpate(t);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
