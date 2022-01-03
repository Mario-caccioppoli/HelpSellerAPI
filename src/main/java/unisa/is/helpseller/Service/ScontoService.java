
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.Sconto;
import unisa.is.helpseller.Repo.ScontoRepo;

@Service
@Transactional
public class ScontoService {
    private final ScontoRepo scontoRepo;
    
    @Autowired
    public ScontoService(ScontoRepo scontoRepo) {this.scontoRepo = scontoRepo;}
    
    public Sconto addSconto(Sconto a) {
        return scontoRepo.save(a);
    }
    
    public List<Sconto> findAllSconto() {
        return scontoRepo.findAll();
    }
    
    public Sconto updateSconto(Sconto a) {
        return scontoRepo.save(a);
    }
    
    public Sconto findScontoById(long id) {
        return scontoRepo.getById(id);
    }
    
    public void deleteSconto(Sconto a) {
        scontoRepo.delete(a);
    }
    
}
