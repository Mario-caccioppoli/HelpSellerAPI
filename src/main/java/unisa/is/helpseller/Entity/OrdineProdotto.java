package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.OrdineProdottoModel;


@Entity
@IdClass(OrdineProdottoId.class)
@Table(name = "ordine_prodotto")
public class OrdineProdotto implements Serializable{
    @Id
    private int id_ordine;
    
    @Id
    private int id_prodotto;
    
    private int quantita_ordine;
    private double prezzo_unitario;
    private double prezzo_ordine;
 
    public OrdineProdotto() {}

    public OrdineProdotto(int id_ordine, int id_prodotto, int quantita_ordine, double prezzo_unitario, double prezzo_ordine) {
        this.id_ordine = id_ordine;
        this.id_prodotto = id_prodotto;
        this.quantita_ordine = quantita_ordine;
        this.prezzo_unitario = prezzo_unitario;
        this.prezzo_ordine = prezzo_ordine;
    }
    
    public OrdineProdotto(OrdineProdottoModel opm) {
        this.id_ordine = opm.getIdOrdine();
        this.id_prodotto = opm.getProdotto().getId();
        this.quantita_ordine = opm.getQuantitaOrdine();
        this.prezzo_unitario = opm.getPrezzoUnitario();
        this.prezzo_ordine = quantita_ordine * prezzo_unitario;
    }

    public int getIdOrdine() {
        return id_ordine;
    }

    public void setIdOrdine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public int getIdProdotto() {
        return id_prodotto;
    }

    public void setIdProdotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public int getQuantitaOrdine() {
        return quantita_ordine;
    }

    public void setQuantitaOrdine(int quantita_ordine) {
        this.quantita_ordine = quantita_ordine;
    }

    public double getPrezzoUnitario() {
        return prezzo_unitario;
    }

    public void setPrezzoUnitario(double prezzo_unitario) {
        this.prezzo_unitario = prezzo_unitario;
    }

    public double getPrezzo() {
        return prezzo_ordine;
    }

    public void setPrezzo(double prezzo_ordine) {
        this.prezzo_ordine = prezzo_ordine;
    }

}
