package unisa.is.helpseller.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "azienda")
public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idAzienda;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    @Column
    private String nomeAzienda;
    
    @Column
    private String VAT;
    
    @Column
    private String indirizzo;
    
    @Column
    private String descrizione;
    
    @Column
    private String logo;
    
    public Azienda() {}
    
    public Azienda(String email, String password, String nomeAzienda, String VAT,
            String indirizzo, String descrizione, String logo) {
        
        this.email = email;
        this.password = password;
        this.nomeAzienda = nomeAzienda;
        this.VAT = VAT;
        this.indirizzo = indirizzo;
        this.descrizione = descrizione;
        this.logo = logo;
    }
        
}
