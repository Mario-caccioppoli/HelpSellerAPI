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
                distributoriModel = distributori.stream().map(p -> {
                    return new DistributoreModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(distributoriModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<DistributoreModel> findId(@PathVariable("id") int id) {
        try {
            Distributore distributore = distributoreService.findId(id);
            if(!distributore.equals(null)) {
                DistributoreModel d = new DistributoreModel(distributore);
                return new ResponseEntity<>(d, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = distributoreService.deleteId(id);
            if(result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);  
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody DistributoreModel d) {
        try {
            Distributore distributore = new Distributore(d);
            if(!distributore.equals(null)) {
                int id = distributoreService.insert(distributore);
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody DistributoreModel d) {
        try {
            Distributore distributore = new Distributore(d);
            int id = distributoreService.update(distributore);
            if(id > 0){
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
