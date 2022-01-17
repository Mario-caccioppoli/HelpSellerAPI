package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.util.List;
import unisa.is.helpseller.Entity.Azienda;


public class AziendaModel implements Serializable {

    private int id;
    private String email;
    private String password;
    private String nomeAzienda;
    private String vat;
    private String indirizzo;
    private String descrizione;
    private String logo;
    private List<ProdottoModel> prodotti;
    private List<OrdineModel> ordini;
    
    public AziendaModel() {}

    public AziendaModel(String email, String password, String nomeAzienda, String vat, String indirizzo, String descrizione, String logo, List<ProdottoModel> prodotti, List<OrdineModel> ordini) {
        this.email = email;
        this.password = password;
        this.nomeAzienda = nomeAzienda;
        this.vat = vat;
        this.indirizzo = indirizzo;
        this.descrizione = descrizione;
        this.logo = logo;
        this.prodotti = prodotti;
        this.ordini = ordini;
    }
    
    public AziendaModel(Azienda a) {
        this.id = a.getId();
        this.email = a.getEmail();
        this.password = a.getPassword();
        this.nomeAzienda = a.getNomeAzienda();
        this.vat = a.getvat();
        this.indirizzo = a.getIndirizzo();
        this.descrizione = a.getDescrizione();
        this.logo = a.getLogo();
        this.prodotti = null;
        this.ordini = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
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

    public List<ProdottoModel> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<ProdottoModel> prodotti) {
        this.prodotti = prodotti;
    }

    public List<OrdineModel> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<OrdineModel> ordini) {
        this.ordini = ordini;
    }
    


   
    
}
