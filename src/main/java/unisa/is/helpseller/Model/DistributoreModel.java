package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

public class DistributoreModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String username;    
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String vat;
    private String telefono;
    private String indirizzoSede;
    private int idOrdineProva;
    private List<OrdineModel> ordini;
    
    public DistributoreModel() {}

    public DistributoreModel(String username, String email, String password, 
            String nome, String cognome, String VAT, String telefono, 
            String indirizzoSede, int idOrdineProva) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.vat = VAT;
        this.telefono = telefono;
        this.indirizzoSede = indirizzoSede;
        this.idOrdineProva = idOrdineProva;
    }

    public long getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVAT() {
        return vat;
    }

    public void setVAT(String VAT) {
        this.vat = VAT;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzoSede() {
        return indirizzoSede;
    }

    public void setIndirizzoSede(String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }

    public int getIdOrdineProva() {
        return idOrdineProva;
    }

    public void setIdOrdineProva(int idOrdineProva) {
        this.idOrdineProva = idOrdineProva;
    }
    
    
}
