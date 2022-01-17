package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.ProdottoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Prodotto;
import unisa.is.helpseller.Model.ProdottoModel;

@RestController
@RequestMapping("/prodotto")
@CrossOrigin("http://localhost:4200")
public class ProdottoController {

    @Autowired
    private final ProdottoService prodottoService;

    @Autowired
    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProdottoModel>> findAll() {
        try {
            List<Prodotto> prodotti = prodottoService.findAll();
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<ProdottoModel> findId(@PathVariable("id") int id) {
        try {
            Prodotto prodotto = prodottoService.findId(id);
            ProdottoModel p = new ProdottoModel(prodotto);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<ProdottoModel> deleteId(@PathVariable("id") int id) {
        try {
            prodottoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ProdottoModel> insert(ProdottoModel prod) {
        try {
            Prodotto p = new Prodotto(prod);
            prodottoService.insert(p);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ProdottoModel> update(ProdottoModel prod) {
        try {
            Prodotto p = new Prodotto(prod);
            prodottoService.udpate(p);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiByAzienda/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByAzienda(@PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByAzienda(id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiByNome/{name}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByNome(@PathVariable("name") String name) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByNome(name);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiByNomeInAzienda/{name}/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByNomeInAzienda(@PathVariable("name") String name, @PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByNomeInAzienda(name, id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiInOrdine/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiInOrdine(@PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiInOrdine(id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiBySconto/{id}")
    public ResponseEntity<List<ProdottoModel>> findProdottiInSconto(@PathVariable("id") int id) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiBySconto(id);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProdottiByIdInAzienda/{id_prodotto}/{id_azienda}")
    public ResponseEntity<List<ProdottoModel>> findProdottiByIdInAzienda(@PathVariable("id_prodotto") int id_prodotto, @PathVariable("id_azienda") int id_azienda) {
        try {
            List<Prodotto> prodotti = prodottoService.findProdottiByIdInAzienda(id_prodotto, id_azienda);
            List<ProdottoModel> prodottiModel = new ArrayList<ProdottoModel>();
            if (prodotti.size() > 0) {
                prodottiModel = prodotti.stream().map(p -> {
                    return new ProdottoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(prodottiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(prodottiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
