package unisa.is.helpseller.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "sconto_prodotto")
public class ScontoProdotto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idSconto;
    
    @Column
    private int idProdotto;
    

    public ScontoProdotto() {}

    public ScontoProdotto(int idSconto, int idProdotto) {
        this.idSconto = idSconto;
        this.idProdotto = idProdotto;
    }
    
    
}