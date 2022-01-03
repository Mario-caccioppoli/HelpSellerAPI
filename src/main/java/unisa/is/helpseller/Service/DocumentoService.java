
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.Documento;
import unisa.is.helpseller.Repo.DocumentoRepo;

@Service
@Transactional
public class DocumentoService {
    private final DocumentoRepo documentoRepo;
    
    @Autowired
    public DocumentoService(DocumentoRepo documentoRepo) {this.documentoRepo = documentoRepo;}
    
    public Documento addDocumento(Documento a) {
        return documentoRepo.save(a);
    }
    
    public List<Documento> findAllDocumento() {
        return documentoRepo.findAll();
    }
    
    public Documento updateDocumento(Documento a) {
        return documentoRepo.save(a);
    }
    
    public Documento findDocumentoById(long id) {
        return documentoRepo.getById(id);
    }
    
    public void deleteDocumento(Documento a) {
        documentoRepo.delete(a);
    }
    
}
