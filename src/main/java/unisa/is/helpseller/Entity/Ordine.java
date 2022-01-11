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
    
    private Date data_ordinazione;
    private Date data_consegna;
    private String commento;
    private String stato;
    private int id_distributore;
    private int id_ordine_prova;
 
    public Ordine() {}

    public Ordine(Date data_ordinazione, Date data_consegna, String commento, int id_distributore, int id_ordine_prova) {
        this.data_ordinazione = data_ordinazione;
        this.data_consegna = data_consegna;
        this.commento = commento;
        this.id_distributore = id_distributore;
        this.id_ordine_prova = id_ordine_prova;
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

    public int getIdOrdineProva() {
        return id_ordine_prova;
    }

    public void setIdOrdineProva(int id_ordine_prova) {
        this.id_ordine_prova = id_ordine_prova;
    }
    
    
}
