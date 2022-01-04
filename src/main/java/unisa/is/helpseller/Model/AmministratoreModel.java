package unisa.is.helpseller.Model;


import java.io.Serializable;
import javax.persistence.*;


public class AmministratoreModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idAmministratore;
    private String username;
    private String email;
    private String password;
    
    public AmministratoreModel() {}
    
    public AmministratoreModel(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public int getIdAmministratore() {
        return idAmministratore;
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
