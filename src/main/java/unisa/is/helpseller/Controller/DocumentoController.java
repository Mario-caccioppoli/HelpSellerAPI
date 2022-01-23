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

/**
 * classe di mappatura dei servizi relativi a Documento affinché siano accessibili dal frontend
 */
@RestController
@RequestMapping("/documento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentoController {

    @Autowired
    private final DocumentoService documentoService;

    @Autowired
    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Documento> lista di oggetti entity
     */
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

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
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

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
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

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param Documento oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody DocumentoModel doc) {
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

    /**
     * metodo per l'update di una entità presente nel DB
     * @param Documento oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody DocumentoModel doc) {
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

    /**
     * metodo di ricerca di un documento dato l'id di un ordine
     * @param int id dell'ordine
     * @return List<Documento> lista dei documenti recuperati
     */
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
