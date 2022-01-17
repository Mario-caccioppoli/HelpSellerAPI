package unisa.is.helpseller.Entity;


import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
import unisa.is.helpseller.Model.RecensioneModel;


@Entity
@Table(name = "recensione")
public class Recensione implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String testo;
    private int voto;
    private Date data;
    private int id_prodotto;
    private int id_distributore;

   
    public Recensione() {}

    public Recensione(String testo, int voto, Date data, int id_prodotto, int id_distributore) {
        this.testo = testo;
        this.voto = voto;
        this.data = data;
        this.id_prodotto = id_prodotto;
        this.id_distributore = id_distributore;
    }
    
    public Recensione(RecensioneModel r) {
        this.id = r.getId();
        this.testo = r.getTesto();
        this.voto = r.getVoto();
        this.data = r.getData();
        this.id_prodotto = r.getIdProdotto();
        this.id_distributore = r.getIdDistributore();
    }

    public int getId() {
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
        return id_prodotto;
    }

    public void setIdProdotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public int getIdDistributore() {
        return id_distributore;
    }

    public void setIdDistributore(int id_distributore) {
        this.id_distributore = id_distributore;
    }
      
}
