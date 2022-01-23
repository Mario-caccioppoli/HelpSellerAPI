package unisa.is.helpseller.Model;

import java.sql.Date;
import java.io.Serializable;
import unisa.is.helpseller.Entity.Recensione;

/**
 * Classe model utilizzata per la comunicazione col frontend descrittiva dell'entity Recensione
 */
public class RecensioneModel implements Serializable{

    private int id;
    private String testo;
    private int voto;
    private Date data;
    private int idProdotto;
    private int idDistributore;

   
    public RecensioneModel() {}

    public RecensioneModel(String testo, int voto, Date data, int idProdotto, int idDistributore) {
        this.testo = testo;
        this.voto = voto;
        this.data = data;
        this.idProdotto = idProdotto;
        this.idDistributore = idDistributore;
    }

    public RecensioneModel(Recensione r) {
        this.id = r.getId();
        this.testo = r.getTesto();
        this.voto = r.getVoto();
        this.data = r.getData();
        this.idProdotto = r.getIdProdotto();
        this.idDistributore = r.getIdDistributore();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdDistributore() {
        return idDistributore;
    }

    public void setIdDistributore(int idDistributore) {
        this.idDistributore = idDistributore;
    }

   
      
}