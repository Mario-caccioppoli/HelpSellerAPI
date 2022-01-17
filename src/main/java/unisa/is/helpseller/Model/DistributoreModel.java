package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.util.List;


public class DistributoreModel implements Serializable{

    private int id;
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

    public DistributoreModel(int id, String username, String email, String password, String nome, String cognome, String vat, String telefono, String indirizzoSede, int idOrdineProva, List<OrdineModel> ordini) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.vat = vat;
        this.telefono = telefono;
        this.indirizzoSede = indirizzoSede;
        this.idOrdineProva = idOrdineProva;
        this.ordini = ordini;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
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

    public List<OrdineModel> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<OrdineModel> ordini) {
        this.ordini = ordini;
    }

   
    
    
}
