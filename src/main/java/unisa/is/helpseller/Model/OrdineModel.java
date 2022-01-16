package unisa.is.helpseller.Model;


import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Entity.Ordine;


public class OrdineModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date dataOrdinazione;
    private Date dataConsegna;
    private String commento;
    private String stato;
    private int idDistributore;
    private int idOrdineProva;
    private DocumentoModel documento;
    private int prezzoTotale;
 
    public OrdineModel() {}

    public OrdineModel(Date dataOrdinazione, Date dataConsegna, String commento, int idDistributore, int idOrdineProva) {
        this.dataOrdinazione = dataOrdinazione;
        this.dataConsegna = dataConsegna;
        this.commento = commento;
        this.idDistributore = idDistributore;
        this.idOrdineProva = idOrdineProva;
        this.stato = "Generated";
    }
    
    public OrdineModel(Ordine o) {
        this.id = o.getId();
        this.dataOrdinazione = o.getDataOrdinazione();
        this.dataConsegna = o.getDataConsegna();
        this.commento = o.getCommento();
        this.idDistributore = o.getIdDistributore();
        this.idOrdineProva = o.getId_ordine_prova();
        this.stato = "Generated";
    }

    public long getId() {
        return id;
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
    
    
}