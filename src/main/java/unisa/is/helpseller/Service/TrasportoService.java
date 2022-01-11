
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

    public List<Trasporto> findAll() {
        return trasportoRepo.findAll();
    }

    public Trasporto findId(int id) {
        return trasportoRepo.findId(id);
    }
    
    public void deleteId(int id) {
        trasportoRepo.deleteId(id);
    }
    
    public void insert(Trasporto tr) {
        trasportoRepo.insert(tr.getIdOrdine(), tr.getDataConsegna(), tr.getIndirizzoConsegna(), tr.getQuantitaMinima());
    }
    
    public void udpate(Trasporto tr) {
        trasportoRepo.update(tr.getIdOrdine(), tr.getDataConsegna(), tr.getIndirizzoConsegna(), tr.getQuantitaMinima(), tr.getId());
    }
}
