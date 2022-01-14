package unisa.is.helpseller.Model;

import java.io.Serializable;
import unisa.is.helpseller.Entity.Prodotto;

public class OrdineProdottoModel implements Serializable {

    private int idOrdine;
    private int quantitaOrdine;
    private double prezzoUnitario;
    private Prodotto prodotto;

    public OrdineProdottoModel() {
    }

    public OrdineProdottoModel(int idOrdine, int quantitaOrdine, double prezzoUnitario, Prodotto prodotto) {
        this.idOrdine = idOrdine;
        this.quantitaOrdine = quantitaOrdine;
        this.prezzoUnitario = prezzoUnitario;
        this.prodotto = prodotto;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getQuantitaOrdine() {
        return quantitaOrdine;
    }

    public void setQuantitaOrdine(int quantitaOrdine) {
        this.quantitaOrdine = quantitaOrdine;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

}
