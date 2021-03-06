package unisa.is.helpseller.Model;


import java.sql.Date;

import java.io.Serializable;
import unisa.is.helpseller.Entity.Trasporto;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity Trasporto
 */
public class TrasportoModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String indirizzoConsegna;
    private int quantitaMinima;
    private Date dataConsegna;
    private int idOrdine;

    public TrasportoModel() {}

    public TrasportoModel(int id, String indirizzoConsegna, int quantitaMinima, Date dataConsegna, int idOrdine) {
        this.id = id;
        this.indirizzoConsegna = indirizzoConsegna;
        this.quantitaMinima = quantitaMinima;
        this.dataConsegna = dataConsegna;
        this.idOrdine = idOrdine;
    }
    
    public TrasportoModel(Trasporto t) {
        this.id = t.getId();
        this.indirizzoConsegna = t.getIndirizzoConsegna();
        this.quantitaMinima = t.getQuantitaMinima();
        this.dataConsegna = t.getDataConsegna();
        this.idOrdine = t.getIdOrdine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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