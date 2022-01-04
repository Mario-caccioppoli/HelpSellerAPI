
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.Azienda;
import unisa.is.helpseller.Repo.AziendaRepo;

@Service
@Transactional
public class AziendaService {
    private final AziendaRepo aziendaRepo;
    
    @Autowired
    public AziendaService(AziendaRepo aziendaRepo) {this.aziendaRepo = aziendaRepo;}
    
    public Azienda addAzienda(Azienda a) {
        return aziendaRepo.save(a);
    }
    
    public List<Azienda> findAllAzienda() {
        return aziendaRepo.findAll();
    }
    
    public Azienda updateAzienda(Azienda a) {
        return aziendaRepo.save(a);
    }
    
    public Azienda findAziendaById(long id) {
        return aziendaRepo.getById(id);
    }
    
    public void deleteAzienda(Long id) {
        aziendaRepo.deleteById(id);
    }
    
}
