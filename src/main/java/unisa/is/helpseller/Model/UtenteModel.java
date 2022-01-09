/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unisa.is.helpseller.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Entity.Distributore;

/**
 *
 * @author Alex
 */
@Entity
public class UtenteModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String username;
    private String email;
    private String password;
    private String tipo;
    
    public UtenteModel() {}
    
    public UtenteModel(String email, String username, String password, String tipo) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
    //enum?
    public UtenteModel(Amministratore admin){
        this.email = admin.getEmail();
        this.username = admin.getUsername();
        this.password = admin.getPassword();
        this.tipo = "Amministratore";
    }
    
    public UtenteModel(Distributore dist){
        this.email = dist.getEmail();
        this.username = dist.getUsername();
        this.password = dist.getPassword();
        this.tipo = "Distributore";
    }
    
    public UtenteModel(Azienda az){
        this.email = az.getEmail();
        this.username = az.getNomeAzienda();
        this.password = az.getPassword();
        this.tipo = "Azienda";
    }

    public long getId() {
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
