package unisa.is.helpseller.Entity;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name = "trasporto")
public class Trasporto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String indirizzoConsegna;
    private int quantitaMinima;
    private Date dataConsegna;
    private int idOrdine;

    public Trasporto() {}

    public Trasporto(String indirizzoConsegna, int quantitaMinima, Date dataConsegna, int idOrdine) {
        this.indirizzoConsegna = indirizzoConsegna;
        this.quantitaMinima = quantitaMinima;
        this.dataConsegna = dataConsegna;
        this.idOrdine = idOrdine;
    }

    public long getId() {
        return id;
    }

    public String getIndirizzoConsegna() {
        return indirizzoConsegna;
    }

    public void setIndirizzoConsegna(String indirizzoConsegna) {
        this.indirizzoConsegna = indirizzoConsegna;
    }

    public int getQuantitaMinima() {
        return quantitaMinima;
    }

    public void setQuantitaMinima(int quantitaMinima) {
        this.quantitaMinima = quantitaMinima;
    }

    public Date getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(Date dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }
    
    
}
