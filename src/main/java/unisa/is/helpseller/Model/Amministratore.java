package unisa.is.helpseller.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "amministratore")
public class Amministratore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idAmministratore;
    
    @Column
    private String username;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    public Amministratore() {}
    
    public Amministratore(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
}
