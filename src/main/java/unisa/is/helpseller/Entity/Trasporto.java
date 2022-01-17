package unisa.is.helpseller.Entity;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import unisa.is.helpseller.Model.TrasportoModel;


@Entity
@Table(name = "trasporto")
public class Trasporto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String indirizzo_consegna;
    private int quantita_minima;
    private Date data_consegna;
    private int id_ordine;

    public Trasporto() {}

    public Trasporto(String indirizzo_consegna, int quantita_minima, Date data_consegna, int id_ordine) {
        this.indirizzo_consegna = indirizzo_consegna;
        this.quantita_minima = quantita_minima;
        this.data_consegna = data_consegna;
        this.id_ordine = id_ordine;
    }
    
    public Trasporto(TrasportoModel t) {
        this.indirizzo_consegna = t.getIndirizzoConsegna();
        this.quantita_minima = t.getQuantitaMinima();
        this.data_consegna = t.getDataConsegna();
        this.id_ordine = t.getIdOrdine();
    }

    public int getId() {
        return id;
    }

    public String getIndirizzoConsegna() {
        return indirizzo_consegna;
    }

    public void setIndirizzoConsegna(String indirizzo_consegna) {
        this.indirizzo_consegna = indirizzo_consegna;
    }

    public int getQuantitaMinima() {
        return quantita_minima;
    }

    public void setQuantitaMinima(int quantita_minima) {
        this.quantita_minima = quantita_minima;
    }

    public Date getDataConsegna() {
        return data_consegna;
    }

    public void setDataConsegna(Date data_consegna) {
        this.data_consegna = data_consegna;
    }

    public int getIdOrdine() {
        return id_ordine;
    }

    public void setIdOrdine(int id_ordine) {
        this.id_ordine = id_ordine;
    }
    
    
}
