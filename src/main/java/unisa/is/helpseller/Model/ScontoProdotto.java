package unisa.is.helpseller.Model;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "sconto_prodotto")
public class ScontoProdotto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idSconto;
    private int idProdotto;

    public ScontoProdotto() {}

    public ScontoProdotto(int idSconto, int idProdotto) {
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