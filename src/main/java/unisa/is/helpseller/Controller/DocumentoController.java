package unisa.is.helpseller.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DocumentoService;
import java.util.List;
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
    public ResponseEntity<List<Documento>> findAll() {
        try {
            List<Documento> documenti = documentoService.findAll();
            return new ResponseEntity<>(documenti, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Documento> findId(@PathVariable("id") int id) {
        try {
            Documento documento = documentoService.findId(id);
            return new ResponseEntity<>(documento, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Documento> deleteId(@PathVariable("id") int id) {
        try {
            documentoService.deleteId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Documento> insert(Documento doc) {
        try {
            documentoService.insert(doc);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Documento> update(Documento doc) {
        try {
            documentoService.udpate(doc);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findDocumentiByOrdine/{id}")
    public ResponseEntity<List<DocumentoModel>> findDocumentiByOrdine(@PathVariable("id") int id) {
        try {
            List<Documento> docList = documentoService.findDocumentiByOrdine(id);
            List<DocumentoModel> modelList = new ArrayList<DocumentoModel>();

            for (Documento doc : docList) {
                DocumentoModel modelBuf = new DocumentoModel(doc.getId(), doc.getTitolo(), doc.getAutore(), doc.getData(), doc.getIdOrdine());
                modelList.add(modelBuf);
            }

            return new ResponseEntity<>(modelList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
