package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "prodotto")
public class Prodotto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idProdotto;
    private String nomeProdotto;
    private double prezzo;
    private String descrizione;
    private int quantita;
    private String immagine;
    private int quantitaMinima;
    private int peso;
    private int volume;
    private int idAzienda;
    
 
    public Prodotto() {}

    public Prodotto(String nomeProdotto, double prezzo, String descrizione, int quantita, String immagine, int quantitaMinima, int peso, int volume, int idAzienda) {
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.immagine = immagine;
        this.quantitaMinima = quantitaMinima;
        this.peso = peso;
        this.volume = volume;
        this.idAzienda = idAzienda;
    }

    public long getId() {
        return id;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getQuantitaMinima() {
        return quantitaMinima;
    }

    public void setQuantitaMinima(int quantitaMinima) {
        this.quantitaMinima = quantitaMinima;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }
    
    
    
}