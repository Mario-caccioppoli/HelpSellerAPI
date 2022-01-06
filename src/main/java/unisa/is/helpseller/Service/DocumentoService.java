
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Documento;
import unisa.is.helpseller.Repo.DocumentoRepo;

@Service
@Transactional
public class DocumentoService {
    private final DocumentoRepo documentoRepo;
    
    @Autowired
    public DocumentoService(DocumentoRepo documentoRepo) {this.documentoRepo = documentoRepo;}
    
    public List<Documento> findAll() {
        return documentoRepo.findAll();
    }
    
    public Documento findId(int id) {
        return documentoRepo.findId(id);
    }
    
    public void deleteId(int id) {
        documentoRepo.deleteId(id);
    }
    
}
