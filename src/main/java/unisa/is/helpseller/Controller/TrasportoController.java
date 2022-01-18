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
            TrasportoModel t = new TrasportoModel(trasporto);
            return new ResponseEntity<>(t, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<TrasportoModel> deleteId(@PathVariable("id") int id) {
        try {
            trasportoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<TrasportoModel> insert(TrasportoModel tr) {
        try {
            Trasporto t = new Trasporto(tr);
            trasportoService.insert(t);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<TrasportoModel> update(TrasportoModel tr) {
        try {
            Trasporto t = new Trasporto(tr);
            trasportoService.udpate(t);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
