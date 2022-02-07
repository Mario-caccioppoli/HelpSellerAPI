package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.util.List;
import unisa.is.helpseller.Entity.Distributore;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity Distributore
 */
public class DistributoreModel implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String username;    
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String vat;
    private String telefono;
    private String indirizzoSede;
    private Integer idOrdineProva;
    private List<OrdineModel> ordini;
    
    public DistributoreModel() {}

    public DistributoreModel(String username, String email, String password, String nome, String cognome, String vat, String telefono, String indirizzoSede, Integer idOrdineProva, List<OrdineModel> ordini) {
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
    
    public DistributoreModel(Distributore d) {
        this.id = d.getId();
        this.username = d.getUsername();
        this.email = d.getEmail();
        this.password = d.getPassword();
        this.nome = d.getNome();
        this.cognome = d.getCognome();
        this.vat = d.getvat();
        this.telefono = d.getTelefono();
        this.indirizzoSede = d.getIndirizzoSede();
        this.idOrdineProva = d.getIdOrdineProva();
        this.ordini = null;
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

    public Integer getIdOrdineProva() {
        return idOrdineProva;
    }

    public void setIdOrdineProva(Integer idOrdineProva) {
        this.idOrdineProva = idOrdineProva;
    }

    public List<OrdineModel> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<OrdineModel> ordini) {
        this.ordini = ordini;
    }

   
    
    
}
