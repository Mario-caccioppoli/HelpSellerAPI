
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
	@Autowired
    private final ScontoRepo scontoRepo;
    
    @Autowired
    public ScontoService(ScontoRepo scontoRepo) {this.scontoRepo = scontoRepo;}

    public List<Sconto> findAll() {
        return scontoRepo.findAll();
    }

    public Sconto findId(int id) {
        return scontoRepo.findId(id);
    }
    
    public int deleteId(int id) {
    	return scontoRepo.deleteId(id);
    }
    
    public int insert(Sconto sc) {
    	 return scontoRepo.saveAndFlush(sc).getId();
    	//return scontoRepo.insert(sc.getPercentuale(), sc.getTipo(), sc.getQuantita(), sc.getIdAzienda(), sc.getDataFine(), sc.getDataInizio());
    }
    
    public int udpate(Sconto sc) {
    	return scontoRepo.update(sc.getNome(), sc.getPercentuale(), sc.getTipo(), sc.getQuantita(), sc.getIdAzienda(), 
                sc.getDataFine(), sc.getDataInizio(), sc.getId());
    }
    
    public List<Sconto> findScontiByAzienda(int id_azienda) {
       return scontoRepo.findScontiByAzienda(id_azienda);
    }
    
    public List<Sconto> findScontiByTipo(String tipo) {
        return scontoRepo.findScontiByTipo(tipo);
    }
    
}
