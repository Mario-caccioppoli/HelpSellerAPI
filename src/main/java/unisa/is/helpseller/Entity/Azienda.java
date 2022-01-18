package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.AziendaModel;


@Entity
@Table(name = "azienda")
public class Azienda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String email;
    private String password;
    private String nome_azienda;
    private String vat;
    private String indirizzo;
    private String descrizione;
    private String logo;
    
    public Azienda() {}
    
    public Azienda(String email, String password, String nome_azienda, String vat,
            String indirizzo, String descrizione, String logo) {
        
        this.email = email;
        this.password = password;
        this.nome_azienda = nome_azienda;
        this.vat = vat;
        this.indirizzo = indirizzo;
        this.descrizione = descrizione;
        this.logo = logo;
    }
    
    public Azienda(AziendaModel a) {
        this.id = a.getId();
        this.email = a.getEmail();
        this.password = a.getPassword();
        this.nome_azienda = a.getNomeAzienda();
        this.vat = a.getVat();
        this.indirizzo = a.getIndirizzo();
        this.descrizione = a.getDescrizione();
        this.logo = a.getLogo();
    }
    
    public int getId() {
        return id;
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

    public String getNomeAzienda() {
        return nome_azienda;
    }

    public void setNomeAzienda(String nome_azienda) {
        this.nome_azienda = nome_azienda;
    }

    public String getvat() {
        return vat;
    }

    public void setvat(String vat) {
        this.vat = vat;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
        
    
}
