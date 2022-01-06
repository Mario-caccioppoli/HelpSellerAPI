
package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.DocumentoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Documento;

@RestController
@RequestMapping("/documento")
@CrossOrigin("http://localhost:4200")
public class DocumentoController {
    private final DocumentoService documentoService;
    
    @Autowired
    public DocumentoController(DocumentoService documentoService) {this.documentoService = documentoService;}
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Documento>> findAll() {
        List<Documento> documenti = documentoService.findAll();
        return new ResponseEntity<>(documenti, HttpStatus.OK);
    }
    
    @GetMapping("/findId/{id}")
    public ResponseEntity<Documento> findId(@PathVariable("id") int id) {
        Documento documento = documentoService.findId(id);
        return new ResponseEntity<>(documento, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Documento> deleteId(@PathVariable("id") int id) {
        documentoService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
