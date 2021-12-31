package unisa.is.helpseller.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "distributore")
public class Distributore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idDistributore;
    
    @Column
    private String username;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    @Column
    private String nome;
    
    @Column
    private String cognome;
    
    @Column
    private String VAT;
    
    @Column
    private String telefono;
    
    @Column
    private String indirizzoSede;
    
    @Column
    private int idOrdineProva;
    
 
    public Distributore() {}

    public Distributore(String username, String email, String password, 
            String nome, String cognome, String VAT, String telefono, 
            String indirizzoSede, int idOrdineProva) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.VAT = VAT;
        this.telefono = telefono;
        this.indirizzoSede = indirizzoSede;
        this.idOrdineProva = idOrdineProva;
    }
    
    
}
