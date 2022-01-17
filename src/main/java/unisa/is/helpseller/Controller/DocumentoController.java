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

    @GetMapping("/findId/{id}")
    public ResponseEntity<DocumentoModel> findId(@PathVariable("id") int id) {
        try {
            Documento documento = documentoService.findId(id);
            DocumentoModel d = new DocumentoModel(documento);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<DocumentoModel> deleteId(@PathVariable("id") int id) {
        try {
            documentoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<DocumentoModel> insert(DocumentoModel doc) {
        try {
            Documento d = new Documento(doc);
            documentoService.insert(d);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<DocumentoModel> update(DocumentoModel doc) {
        try {
            Documento d = new Documento(doc);
            documentoService.udpate(d);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
