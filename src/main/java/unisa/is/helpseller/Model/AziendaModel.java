package unisa.is.helpseller.Model;


import java.io.Serializable;
import javax.persistence.*;

public class AziendaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idAzienda;
    private String email;
    private String password;
    private String nomeAzienda;
    private String vat;
    private String indirizzo;
    private String descrizione;
    private String logo;
    private ProdottoModel prodotti;
    
    public AziendaModel() {}
    
    public AziendaModel(String email, String password, String nomeAzienda, String VAT,
            String indirizzo, String descrizione, String logo) {
        
        this.email = email;
        this.password = password;
        this.nomeAzienda = nomeAzienda;
        this.vat = VAT;
        this.indirizzo = indirizzo;
        this.descrizione = descrizione;
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public int getIdAzienda() {
        return idAzienda;
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
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getVAT() {
        return vat;
    }

    public void setVAT(String VAT) {
        this.vat = VAT;
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
