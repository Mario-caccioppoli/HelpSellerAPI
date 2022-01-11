package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(ScontoProdottoId.class)
@Table(name = "sconto_prodotto")
public class ScontoProdotto implements Serializable {
    @Id
    private int id_sconto;
    
    @Id
    private int id_prodotto;

    public ScontoProdotto() {}

    public ScontoProdotto(int id_sconto, int id_prodotto) {
        this.id_sconto = id_sconto;
        this.id_prodotto = id_prodotto;
    }


    public int getIdSconto() {
        return id_sconto;
    }

    public void setIdSconto(int id_sconto) {
        this.id_sconto = id_sconto;
    }

    public int getIdProdotto() {
        return id_prodotto;
    }

    public void setIdProdotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    
    
}
