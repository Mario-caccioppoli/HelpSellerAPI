
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
    private final AziendaRepo aziendaRepo;
    
    @Autowired
    public AziendaService(AziendaRepo aziendaRepo) {this.aziendaRepo = aziendaRepo;}
    
    public List<Azienda> findAll() {
        return aziendaRepo.findAll();
    }
    
    public Azienda findId(int id) {
        return aziendaRepo.findId(id);
    }
    
    public void deleteId(int id) {
        aziendaRepo.deleteId(id);
    }
    
    public void insert(String email, String password, String nome_azienda, 
           String indirizzo,  String vat, String descrizione, String logo) {
        aziendaRepo.insert(email, password, nome_azienda, indirizzo, vat, descrizione, logo);
    }
    
      public void updatePassword(String value, int id) {
        aziendaRepo.updatePassword(value, id);
    }
}
