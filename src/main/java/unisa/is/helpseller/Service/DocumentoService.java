
package unisa.is.helpseller.Service;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import static org.apache.tomcat.jni.User.username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Documento;
import unisa.is.helpseller.Repo.DocumentoRepo;

/**
 *  Classe contenente tutti i servizi relativi all'entity Documento
 *
 */
@Service
@Transactional
public class DocumentoService {
	@Autowired
    private final DocumentoRepo documentoRepo;
    
    @Autowired
    public DocumentoService(DocumentoRepo documentoRepo) {this.documentoRepo = documentoRepo;}

    /**
     * metodo per il recupero di tutti le istanze presenti nel DB
     * @return List<Documento> lista di oggetti entity
     */
    public List<Documento> findAll() {
        return documentoRepo.findAll();
    }

    /**
     * metodo per il recupero di una istanza dal DB dato in input il suo ID
     * @param id    intero ID dell'entità ricercata
     * @return oggetto prelevato dal DB, se presente
     */
    public Documento findId(int id) {
        return documentoRepo.findId(id);
    }

    /**
     * metodo per la rimozione di una istanza dato l'id
     * @param id    id dell'entità da rimuovere
     * @return int id dell'entità rimossa
     */
    public int deleteId(int id) {
    	return documentoRepo.deleteId(id);
    }

    /**
     * metodo per l'inserimento di un'istanza nel DB
     * @param doc Documento oggetto entity da inserire nel DB
     * @return int id dell'entità aggiunta
     */
    public int insert(Documento doc) {
    	return documentoRepo.saveAndFlush(doc).getId();
    }

    /**
     * metodo per l'update di una entità presente nel DB
     * @param doc Documento oggetto entity da modificare nel DB
     * @return int id dell'entity modificata
     */
    public int udpate(Documento doc) {
    	return documentoRepo.update(doc.getTitolo(), doc.getAutore(), doc.getIdOrdine(), doc.getData(), doc.getId());
    }

    /**
     * metodo di ricerca di un documento dato l'id di un ordine
     * @param id dell'ordine
     * @return List<Documento> lista dei documenti recuperati
     */
    public List<Documento> findDocumentiByOrdine(int id) {
        return documentoRepo.findDocumentiByOrdine(id);
    }
}
