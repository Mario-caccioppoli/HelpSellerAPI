package unisa.is.helpseller.Service;

import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Entity.Distributore;
import unisa.is.helpseller.Model.UtenteModel;

/**
 *
 * @author Alex
 */
@Service
@Transactional
public class UtenteService {
    
    //service per l'autenticazione V0.0
    
    public UtenteModel authAdmin(String email, String password, List<Amministratore> admin){
        UtenteModel user;
        Iterator<Amministratore> iterator = admin.iterator();
        while(iterator.hasNext()){
            Amministratore a = iterator.next();
            if(a.getEmail().equals(email)){
                if(a.getPassword().equals(password)){
                    user = new UtenteModel(a);
                    return user;
                }
            }
        }
        return null;
    }
    
    public UtenteModel authDist(String email, String password, List<Distributore> dist){
        UtenteModel user;
        Iterator<Distributore> it = dist.iterator();
        while(it.hasNext()){
            Distributore d = it.next();
            if(d.getEmail().equals(email)){
                if(d.getPassword().equals(password)){
                    user = new UtenteModel(d);
                    return user;
                }
            }
        }
        return null;
    }
    
    public UtenteModel authAzienda(String email, String password, List<Azienda> azienda){
        UtenteModel user;
        Iterator<Azienda> iter = azienda.iterator();
        while(iter.hasNext()){
            Azienda az = iter.next();
            if(az.getEmail().equals(email)){
                if(az.getPassword().equals(password)){
                    user = new UtenteModel(az);
                    return user;
                }
            }
        }
        return null;
    }
}
