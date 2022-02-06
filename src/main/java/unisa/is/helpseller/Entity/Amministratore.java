package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.AmministratoreModel;

/**
 * Classe descrittiva dell'oggetto entity Amministratore
 */
@Entity
@Table(name = "amministratore")
public class Amministratore implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;
    private String email;
    private String password;
    
    public Amministratore() {}
    
    public Amministratore(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public Amministratore(AmministratoreModel a) {
        this.id = a.getId();
        this.username = a.getUsername();
        this.email = a.getEmail();
        this.password = a.getPassword();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
}
