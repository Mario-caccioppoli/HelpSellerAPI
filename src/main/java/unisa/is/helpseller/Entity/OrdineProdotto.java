package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ordine_prodotto")
public class OrdineProdotto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idOrdine;
    private int idProdotto;
    private int quantita;
    private double prezzoUnitario;
 
    public OrdineProdotto() {}

    public OrdineProdotto(int idOrdine, int idProdotto, int quantita, double prezzoUnitario) {
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public long getId() {
        return id;
    }
    
    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    
}