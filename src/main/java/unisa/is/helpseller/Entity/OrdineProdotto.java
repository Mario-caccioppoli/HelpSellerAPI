package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@IdClass(OrdineProdottoId.class)
@Table(name = "ordine_prodotto")
public class OrdineProdotto implements Serializable{
    @Id
    private int id_ordine;
    
    @Id
    private int id_prodotto;
    
    private int quantita;
    private double prezzo_unitario;
    private double prezzo;
 
    public OrdineProdotto() {}

    public OrdineProdotto(int id_ordine, int id_prodotto, int quantita, double prezzo_unitario, double prezzo) {
        this.id_ordine = id_ordine;
        this.id_prodotto = id_prodotto;
        this.quantita = quantita;
        this.prezzo_unitario = prezzo_unitario;
        this.prezzo = prezzo;
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

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzo_unitario;
    }

    public void setPrezzoUnitario(double prezzo_unitario) {
        this.prezzo_unitario = prezzo_unitario;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

}
