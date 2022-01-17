package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.ProdottoModel;


@Entity
@Table(name = "prodotto")
public class Prodotto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nome_prodotto;
    private double prezzo;
    private String descrizione;
    private int quantita;
    private String immagine;
    private int quantita_minima;
    private int peso;
    private int volume;
    private int id_azienda;
    
    
    public Prodotto() {}
    
    public Prodotto(Prodotto p) {}
    
    public Prodotto(String nome_prodotto, double prezzo, String descrizione, int quantita, String immagine, int quantita_minima, int peso, int volume, int id_azienda) {
        this.nome_prodotto = nome_prodotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.immagine = immagine;
        this.quantita_minima = quantita_minima;
        this.peso = peso;
        this.volume = volume;
        this.id_azienda = id_azienda;
    }
    
    public Prodotto(ProdottoModel p) {
        this.id = p.getId();
        this.nome_prodotto = p.getNomeProdotto();
        this.prezzo = p.getPrezzo();
        this.descrizione = p.getDescrizione();
        this.quantita = p.getQuantita();
        this.immagine = p.getImmagine();
        this.quantita_minima = p.getQuantitaMinima();
        this.peso = p.getPeso();
        this.volume = p.getVolume();
        this.id_azienda = p.getIdAzienda();
    }

    public int getId() {
        return id;
    }


    public String getNomeProdotto() {
        return nome_prodotto;
    }

    public void setNomeProdotto(String nome_prodotto) {
        this.nome_prodotto = nome_prodotto;
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
        return quantita_minima;
    }

    public void setQuantitaMinima(int quantita_minima) {
        this.quantita_minima = quantita_minima;
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
        return id_azienda;
    }

    public void setIdAzienda(int id_azienda) {
        this.id_azienda = id_azienda;
    }
    
    
    
}
