package unisa.is.helpseller.Entity;


import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.OrdineModel;


@Entity
@Table(name = "ordine")
public class Ordine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private Date data_ordinazione;
    private Date data_consegna;
    private String commento;
    private String stato;
    private int id_distributore;
 
    public Ordine() {}

    public Ordine(Date data_ordinazione, Date data_consegna, String commento, int id_distributore) {
        this.data_ordinazione = data_ordinazione;
        this.data_consegna = data_consegna;
        this.commento = commento;
        this.id_distributore = id_distributore;
        this.stato = "Generated";
    }
    
    public Ordine(OrdineModel o) {
        this.id = o.getId();
        this.data_ordinazione = o.getDataOrdinazione();
        this.data_consegna = o.getDataConsegna();
        this.commento = o.getCommento();
        this.id_distributore = o.getIdDistributore();
        this.stato = "Generated";
    }

    public int getId() {
        return id;
    }

    public Date getDataOrdinazione() {
        return data_ordinazione;
    }

    public void setDataOrdinazione(Date data_ordinazione) {
        this.data_ordinazione = data_ordinazione;
    }

    public Date getDataConsegna() {
        return data_consegna;
    }

    public void setDataConsegna(Date data_consegna) {
        this.data_consegna = data_consegna;
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
        return id_distributore;
    }

    public void setIdDistributore(int id_distributore) {
        this.id_distributore = id_distributore;
    }
}
