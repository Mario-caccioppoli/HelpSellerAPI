package unisa.is.helpseller.Service;

import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
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
    public UtenteModel auth(String username, String password, List<Amministratore> admin, List<Distributore> dist, List<Azienda> azienda){
        UtenteModel user;
        // TO DO ////////////////////////////////////////////////////////////////
        //separare ricerca x tipo con uno switch, il frontend mi specifica il tipo, new variabile
        //finire i parametri in userModel
        //registrazione 
        Iterator<Amministratore> iterator = admin.iterator();
        while(iterator.hasNext()){
            Amministratore a = iterator.next();
            if(a.getEmail().equals(username)){
                if(a.getPassword().equals(password)){
                    user = new UtenteModel(a);
                    return user;
                }
            }
        }
        Iterator<Distributore> it = dist.iterator();
        while(it.hasNext()){
            Distributore d = it.next();
            if(d.getEmail().equals(username)){
                if(d.getPassword().equals(password)){
                    user = new UtenteModel(d);
                    return user;
                }
            }
        }
        //ci siamo dimenticati l'username per l'azienda nel DB mi sa
        Iterator<Azienda> iter = azienda.iterator();
        while(iter.hasNext()){
            Azienda az = iter.next();
            if(az.getEmail().equals(username)){
                if(az.getPassword().equals(password)){
                    user = new UtenteModel(az);
                    return user;
                }
            }
        }
        return null;
    }
}
