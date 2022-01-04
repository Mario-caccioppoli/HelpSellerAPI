
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Trasporto;
import unisa.is.helpseller.Repo.TrasportoRepo;

@Service
@Transactional
public class TrasportoService {
    private final TrasportoRepo trasportoRepo;
    
    @Autowired
    public TrasportoService(TrasportoRepo trasportoRepo) {this.trasportoRepo = trasportoRepo;}
    
    public Trasporto addTrasporto(Trasporto a) {
        return trasportoRepo.save(a);
    }
    
    public List<Trasporto> findAllTrasporto() {
        return trasportoRepo.findAll();
    }
    
    public Trasporto updateTrasporto(Trasporto a) {
        return trasportoRepo.save(a);
    }
    
    public Trasporto findTrasportoById(long id) {
        return trasportoRepo.getById(id);
    }
    
    public void deleteTrasporto(Long id) {
        trasportoRepo.deleteById(id);
    }
    
}
