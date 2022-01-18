package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DocumentoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Documento;
import unisa.is.helpseller.Model.DocumentoModel;

@RestController
@RequestMapping("/documento")
@CrossOrigin("http://localhost:4200")
public class DocumentoController {

    @Autowired
    private final DocumentoService documentoService;

    @Autowired
    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DocumentoModel>> findAll() {
        try {
            List<Documento> documenti = documentoService.findAll();
            List<DocumentoModel> documentiModel = new ArrayList<DocumentoModel>();
            documentiModel = documenti.stream().map(p -> {
                return new DocumentoModel(p);
            }).collect(Collectors.toList());
            return new ResponseEntity<>(documentiModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<DocumentoModel> findId(@PathVariable("id") int id) {
        try {
            Documento documento = documentoService.findId(id);
            if (!documento.equals(null)) {
                DocumentoModel d = new DocumentoModel(documento);
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
            int result = documentoService.deleteId(id);
            if (result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(DocumentoModel doc) {
        try {
            Documento d = new Documento(doc);
            int id = documentoService.insert(d);
            if (id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> update(DocumentoModel doc) {
        try {
            Documento d = new Documento(doc);
            int id = documentoService.udpate(d);
            if (id > 0) {
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findDocumentiByOrdine/{id}")
    public ResponseEntity<List<DocumentoModel>> findDocumentiByOrdine(@PathVariable("id") int id) {
        try {
            List<Documento> documenti = documentoService.findDocumentiByOrdine(id);
            List<DocumentoModel> documentiModel = new ArrayList<DocumentoModel>();
            if (documenti.size() > 0) {
                documentiModel = documenti.stream().map(p -> {
                    return new DocumentoModel(p);
                }).collect(Collectors.toList());
                return new ResponseEntity<>(documentiModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(documentiModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
