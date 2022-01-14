
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
    
    public void insert(Sconto sc) {
        scontoRepo.insert(sc.getPercentuale(), sc.getTipo(), sc.getQuantita(), sc.getIdAzienda(), sc.getDataFine(), sc.getDataInizio());
    }
    
    public void udpate(Sconto sc) {
        scontoRepo.update(sc.getPercentuale(), sc.getTipo(), sc.getQuantita(), sc.getIdAzienda(), sc.getDataFine(), sc.getDataInizio(), sc.getId());
    }
    
    public List<Sconto> findScontiByAzienda(int id_azienda) {
       return scontoRepo.findScontiByAzienda(id_azienda);
    }
    
    public List<Sconto> findScontiByTipo(String tipo) {
        return scontoRepo.findScontiByTipo(tipo);
    }
    
}
