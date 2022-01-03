
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Model.Recensione;
import unisa.is.helpseller.Repo.RecensioneRepo;

@Service
@Transactional
public class RecensioneService {
    private final RecensioneRepo recensioneRepo;
    
    @Autowired
    public RecensioneService(RecensioneRepo recensioneRepo) {this.recensioneRepo = recensioneRepo;}
    
    public Recensione addRecensione(Recensione a) {
        return recensioneRepo.save(a);
    }
    
    public List<Recensione> findAllRecensione() {
        return recensioneRepo.findAll();
    }
    
    public Recensione updateRecensione(Recensione a) {
        return recensioneRepo.save(a);
    }
    
    public Recensione findRecensioneById(long id) {
        return recensioneRepo.getById(id);
    }
    
    public void deleteRecensione(Recensione a) {
        recensioneRepo.delete(a);
    }
    
}
