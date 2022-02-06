package unisa.is.helpseller.Entity;


import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe descrittiva dell'oggetto entity ScontoProdotto
 */
@Entity
@IdClass(ScontoProdottoId.class)
@Table(name = "sconto_prodotto")
public class ScontoProdotto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id_sconto;
    
    @Id
    private Integer id_prodotto;

    public ScontoProdotto() {}

    public ScontoProdotto(Integer id_prodotto, Integer id_sconto) {
        this.id_prodotto = id_prodotto;
        this.id_sconto = id_sconto;
    }


    public int getIdSconto() {
        return id_sconto;
    }

    public void setIdSconto(Integer id_sconto) {
        this.id_sconto = id_sconto;
    }

    public int getIdProdotto() {
        return id_prodotto;
    }

    public void setIdProdotto(Integer id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    
    
}
