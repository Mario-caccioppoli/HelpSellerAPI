package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DistributoreService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Model.DistributoreModel;

@RestController
@RequestMapping("/distributore")
@CrossOrigin("http://localhost:4200")
public class DistributoreController {

    @Autowired
    private final DistributoreService distributoreService;

    @Autowired
    public DistributoreController(DistributoreService distributoreService) {
        this.distributoreService = distributoreService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DistributoreModel>> findAll() {
        try {
            List<Distributore> distributori = distributoreService.findAll();
            List<DistributoreModel> distributoriModel = new ArrayList<DistributoreModel>();
            if (distributori.size() > 0) {
                distributoriModel = distributori.stream().map(p -> {
                    return new DistributoreModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(distributoriModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(distributoriModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<DistributoreModel> findId(@PathVariable("id") int id) {
        try {
            Distributore distributore = distributoreService.findId(id);
            DistributoreModel d = new DistributoreModel(distributore);
            
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<DistributoreModel> deleteId(@PathVariable("id") int id) {
        try {
            distributoreService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<DistributoreModel> insert(DistributoreModel d) {
        try {
            Distributore distributore = new Distributore(d);
            distributoreService.insert(distributore);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<DistributoreModel> update(DistributoreModel d) {
        try {
            Distributore distributore = new Distributore(d);
            distributoreService.update(distributore);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
