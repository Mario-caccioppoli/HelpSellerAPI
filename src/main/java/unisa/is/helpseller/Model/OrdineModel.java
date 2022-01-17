package unisa.is.helpseller.Model;


import java.sql.Date;
import java.io.Serializable;
import unisa.is.helpseller.Entity.Ordine;


public class OrdineModel implements Serializable{

    private int id;
    private Date dataOrdinazione;
    private Date dataConsegna;
    private String commento;
    private String stato;
    private int idDistributore;
    private DocumentoModel documento;
    private double prezzoTotale;
 
    public OrdineModel() {}

    public OrdineModel(Date dataOrdinazione, Date dataConsegna, String commento, String stato, int idDistributore, DocumentoModel documento, double prezzoTotale) {
        this.dataOrdinazione = dataOrdinazione;
        this.dataConsegna = dataConsegna;
        this.commento = commento;
        this.stato = stato;
        this.idDistributore = idDistributore;
        this.documento = documento;
        this.prezzoTotale = prezzoTotale;
    }
    
    public OrdineModel(Ordine o) {
        this.id = o.getId();
        this.dataOrdinazione = o.getDataOrdinazione();
        this.dataConsegna = o.getDataConsegna();
        this.commento = o.getCommento();
        this.stato = o.getStato();
        this.idDistributore = o.getIdDistributore();
        this.documento = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOrdinazione() {
        return dataOrdinazione;
    }

    public void setDataOrdinazione(Date dataOrdinazione) {
        this.dataOrdinazione = dataOrdinazione;
    }

    public Date getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(Date dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getIdDistributore() {
        return idDistributore;
    }

    public void setIdDistributore(int idDistributore) {
        this.idDistributore = idDistributore;
    }

    public DocumentoModel getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoModel documento) {
        this.documento = documento;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    
}