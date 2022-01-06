
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Sconto;
import unisa.is.helpseller.Repo.ScontoRepo;

@Service
@Transactional
public class ScontoService {
    private final ScontoRepo scontoRepo;
    
    @Autowired
    public ScontoService(ScontoRepo scontoRepo) {this.scontoRepo = scontoRepo;}

    public List<Sconto> findAll() {
        return scontoRepo.findAll();
    }

    public Sconto findId(int id) {
        return scontoRepo.findId(id);
    }
    
    public void deleteId(int id) {
        scontoRepo.deleteId(id);
    }
    
}
