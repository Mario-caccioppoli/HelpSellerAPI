package unisa.is.helpseller.Entity;


import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ordine")
public class Ordine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private Date dataOrdinazione;
    private Date dataConsegna;
    private String commento;
    private String stato;
    private int idDistributore;
    private int idOrdineProva;
 
    public Ordine() {}

    public Ordine(Date dataOrdinazione, Date dataConsegna, String commento, int idDistributore, int idOrdineProva) {
        this.dataOrdinazione = dataOrdinazione;
        this.dataConsegna = dataConsegna;
        this.commento = commento;
        this.idDistributore = idDistributore;
        this.idOrdineProva = idOrdineProva;
        this.stato = "Generated";
    }

    public long getId() {
        return id;
    }

    public int getIdOrdine() {
        return idOrdine;
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
