package unisa.is.helpseller.Model;

import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;


public class RecensioneModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public long getId() {
        return id;
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