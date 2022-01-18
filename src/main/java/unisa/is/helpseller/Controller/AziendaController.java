package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AziendaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Model.AziendaModel;

@RestController
@RequestMapping("/azienda")
@CrossOrigin("http://localhost:4200")
public class AziendaController {

    @Autowired
    private final AziendaService aziendaService;

    @Autowired
    public AziendaController(AziendaService aziendaService) {
        this.aziendaService = aziendaService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AziendaModel>> findAll() {
        try {
            List<Azienda> aziende = aziendaService.findAll();
            List<AziendaModel> aziendeModel = new ArrayList<AziendaModel>();
                aziendeModel = aziende.stream().map(p -> {
                    return new AziendaModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(aziendeModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<AziendaModel> findId(@PathVariable("id") int id) {
        try {
            Azienda azienda = aziendaService.findId(id);
            if(!azienda.equals(null)) {
                AziendaModel a = new AziendaModel(azienda);
                return new ResponseEntity<>(a, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable("id") int id) {
        try {
            int result = aziendaService.deleteId(id);
            if(id > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(AziendaModel a) {
        try {
            Azienda azienda = new Azienda(a);
            int id = aziendaService.insert(azienda);
            if(id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }
            
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<AziendaModel> update(AziendaModel a) {
        try {
            Azienda azienda = new Azienda(a);
            int id = aziendaService.update(azienda);
            if(id > 0) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
           
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findAziendaByNome/{name}")
    public ResponseEntity<List<AziendaModel>> findAziendeByNome(@PathVariable("name") String name) {
        try {
            List<Azienda> aziende = aziendaService.findAziendeByNome(name);
            List<AziendaModel> aziendeModel = new ArrayList<AziendaModel>();
            if (aziende.size() > 0) {
                aziendeModel = aziende.stream().map(p -> {
                    return new AziendaModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(aziendeModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(aziendeModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAziendaByProdotto/{id}")
    public ResponseEntity<AziendaModel> findAziendaByProdotto(@PathVariable("id") int id) {
        try {
            Azienda azienda = aziendaService.findAziendaByProdotto(id);
            if(!azienda.equals(null)) {
                AziendaModel aziendaModel = new AziendaModel(azienda);
                return new ResponseEntity<>(aziendaModel, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
