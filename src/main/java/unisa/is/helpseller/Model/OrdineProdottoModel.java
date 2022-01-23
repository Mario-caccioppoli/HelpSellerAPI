package unisa.is.helpseller.Model;

import java.io.Serializable;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity OrdineProdotto
 */
public class OrdineProdottoModel implements Serializable {
    
    private int idOrdine;
    private int quantitaOrdine;
    private double prezzoUnitario;
    private ProdottoModel prodotto;

    public OrdineProdottoModel() {
    }

    public OrdineProdottoModel(int idOrdine, int quantitaOrdine, double prezzoUnitario, ProdottoModel prodotto) {
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

    public ProdottoModel getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoModel prodotto) {
        this.prodotto = prodotto;
    }

    
}
