package unisa.is.helpseller.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "ordine_prodotto")
public class OrdineProdotto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idOrdine;
    
    @Column
    private int idProdotto;
    
    @Column
    private int quantita;
    
    @Column
    private double prezzoUnitario;
 
    public OrdineProdotto() {}

    public OrdineProdotto(int idOrdine, int idProdotto, int quantita, double prezzoUnitario) {
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

}