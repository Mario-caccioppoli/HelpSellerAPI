package unisa.is.helpseller.Model;

import java.io.Serializable;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Entity.Azienda;
import unisa.is.helpseller.Entity.Distributore;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity Utente
 */
public class UtenteModel implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
    
    //attributi in comune per tutte le tipologie di utente, azienda NON ha username
    private String username, email, password, tipo;


    //attributi specifici 
    private String vat, indirizzo, descrizione, nome, cognome, telefono, logo;    
    
    public UtenteModel() {}
    
    public UtenteModel(String email, String username, String password, String tipo) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
    //enum?
    public UtenteModel(Amministratore admin){
        this.id = admin.getId();
        this.email = admin.getEmail();
        this.username = admin.getUsername();
        this.password = admin.getPassword();
        this.tipo = "Amministratore";
    }
    
    //costruttore di un utente dato un distributore
    public UtenteModel(Distributore dist){
        this.id = dist.getId();
        this.email = dist.getEmail();
        this.username = dist.getUsername();
        this.password = dist.getPassword();
        this.tipo = "Distributore";
        this.nome = dist.getNome();
        this.cognome = dist.getCognome();
        this.vat = dist.getvat();
        this.telefono = dist.getTelefono();
        this.indirizzo = dist.getIndirizzoSede();
    }
    
    //costruttore di un utente data un'azienda
    public UtenteModel(Azienda az){
        this.id = az.getId();
        this.email = az.getEmail();
        this.nome = az.getNomeAzienda();
        this.password = az.getPassword();
        this.tipo = "Azienda";
        this.vat = az.getvat();
        this.indirizzo = az.getIndirizzo();
        this.descrizione = az.getDescrizione();
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public String getTipo() {
        return tipo;
    }
}
