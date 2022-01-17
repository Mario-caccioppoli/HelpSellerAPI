package unisa.is.helpseller.Model;


import java.sql.Date;
import java.io.Serializable;


public class OrdineModel implements Serializable{

    private int id;
    private Date dataOrdinazione;
    private Date dataConsegna;
    private String commento;
    private String stato;
    private int idDistributore;
    private int idOrdineProva;
    private DocumentoModel documento;
    private double prezzoTotale;
 
    public OrdineModel() {}

    public OrdineModel(int id, Date dataOrdinazione, Date dataConsegna, String commento, String stato, int idDistributore, int idOrdineProva, DocumentoModel documento, double prezzoTotale) {
        this.id = id;
        this.dataOrdinazione = dataOrdinazione;
        this.dataConsegna = dataConsegna;
        this.commento = commento;
        this.stato = stato;
        this.idDistributore = idDistributore;
        this.idOrdineProva = idOrdineProva;
        this.documento = documento;
        this.prezzoTotale = prezzoTotale;
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

    public int getIdOrdineProva() {
        return idOrdineProva;
    }

    public void setIdOrdineProva(int idOrdineProva) {
        this.idOrdineProva = idOrdineProva;
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