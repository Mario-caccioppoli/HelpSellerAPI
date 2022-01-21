package unisa.is.helpseller.Model;

import java.io.Serializable;
import java.util.List;
import unisa.is.helpseller.Entity.Prodotto;

public class ProdottoModel implements Serializable {

    private int id;
    private String nomeProdotto;
    private double prezzo;
    private String descrizione;
    private int quantita;
    private String immagine;
    private int quantitaMinima;
    private int peso;
    private int volume;
    private int idAzienda;
    private List<RecensioneModel> recensioni;
    private List<ScontoModel> sconti;

    public ProdottoModel() {
    }

    public ProdottoModel(String nomeProdotto, double prezzo, String descrizione, int quantita, String immagine, int quantitaMinima, int peso, int volume, int idAzienda, List<RecensioneModel> recensioni, List<ScontoModel> sconti) {
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.immagine = immagine;
        this.quantitaMinima = quantitaMinima;
        this.peso = peso;
        this.volume = volume;
        this.idAzienda = idAzienda;
        this.recensioni = recensioni;
        this.sconti = sconti;
    }
    
    public ProdottoModel(Prodotto p) {
        this.id = p.getId();
        this.nomeProdotto = p.getNomeProdotto();
        this.prezzo = p.getPrezzo();
        this.descrizione = p.getDescrizione();
        this.quantita = p.getQuantita();
        this.immagine = p.getImmagine();
        this.quantitaMinima = p.getQuantitaMinima();
        this.peso = p.getPeso();
        this.volume = p.getVolume();
        this.idAzienda = p.getIdAzienda();
        this.recensioni = null;
        this.sconti = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<RecensioneModel> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(List<RecensioneModel> recensioni) {
        this.recensioni = recensioni;
    }

    public List<ScontoModel> getSconti() {
        return sconti;
    }

    public void setSconti(List<ScontoModel> sconti) {
        this.sconti = sconti;
    }

}
