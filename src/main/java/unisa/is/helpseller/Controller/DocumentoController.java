
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
    
    @GetMapping("/getall")
    public ResponseEntity<List<Documento>> getAllDocumento() {
        List<Documento> documenti = documentoService.findAllDocumento();
        return new ResponseEntity<>(documenti, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Documento> findDocumentoById(@PathVariable("id") Long id) {
        Documento documento = documentoService.findDocumentoById(id);
        return new ResponseEntity<>(documento, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Documento> addDocumento(@RequestBody Documento documento) {
        Documento newDocumento = documentoService.addDocumento(documento);
        return new ResponseEntity<>(newDocumento, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Documento> updateDocumento(@RequestBody Documento documento) {
        Documento updated = documentoService.updateDocumento(documento);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Documento> deleteDocumento(@PathVariable("id") Long id) {
        documentoService.deleteDocumento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
