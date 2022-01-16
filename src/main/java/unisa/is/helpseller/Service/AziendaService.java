
package unisa.is.helpseller.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Repo.AziendaRepo;

@Service
@Transactional
public class AziendaService {
	@Autowired
    private final AziendaRepo aziendaRepo;
    
    @Autowired
    public AziendaService(AziendaRepo aziendaRepo) {this.aziendaRepo = aziendaRepo;}
    
    public List<Azienda> findAll() {
        return aziendaRepo.findAll();
    }
    
    public Azienda findId(int id) {
        return aziendaRepo.findId(id);
    }
    
    public int deleteId(int id) {
    	return aziendaRepo.deleteId(id);
    }
    
    public int insert(Azienda a) {
    	return aziendaRepo.insert(a.getEmail(), a.getPassword(), a.getNomeAzienda(), a.getIndirizzo(), a.getvat(), a.getDescrizione(), a.getLogo());
    }
    
    public int update(Azienda a) {
    	return aziendaRepo.update(a.getEmail(), a.getPassword(), a.getNomeAzienda(), a.getIndirizzo(), a.getvat(), a.getDescrizione(), a.getLogo(), a.getId());
    }
    
    public List<Azienda> findAziendeByNome(String nome) {
        return aziendaRepo.findAziendeByNome(nome);
    }
    
    public Azienda findAziendaByProdotto(int id_prodotto) {
        return aziendaRepo.findAziendaByProdotto(id_prodotto);
    }
}
