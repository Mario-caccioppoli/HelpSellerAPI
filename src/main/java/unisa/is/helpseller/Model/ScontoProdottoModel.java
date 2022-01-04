package unisa.is.helpseller.Model;


import java.io.Serializable;
import javax.persistence.*;

public class ScontoProdottoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idSconto;
    private int idProdotto;

    public ScontoProdottoModel() {}

    public ScontoProdottoModel(int idSconto, int idProdotto) {
        this.idSconto = idSconto;
        this.idProdotto = idProdotto;
    }

    public long getId() {
        return id;
    }

    public int getIdSconto() {
        return idSconto;
    }

    public void setIdSconto(int idSconto) {
        this.idSconto = idSconto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }
    
    
}