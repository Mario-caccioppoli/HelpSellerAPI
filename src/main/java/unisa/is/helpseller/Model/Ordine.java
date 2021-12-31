package unisa.is.helpseller.Model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idOrdine;
    
    @Column
    private Date dataOrdinazione;
    
    @Column
    private Date dataConsegna;
    
    @Column
    private String commento;
    
    @Column
    private String stato;
    
    @Column
    private int idDistributore;
    
    @Column
    private int idOrdineProva;
 
    public Ordine() {}

    public Ordine(Date dataOrdinazione, Date dataConsegna, String commento, int idDistributore, int idOrdineProva) {
        this.dataOrdinazione = dataOrdinazione;
        this.dataConsegna = dataConsegna;
        this.commento = commento;
        this.idDistributore = idDistributore;
        this.idOrdineProva = idOrdineProva;
        this.stato = "Generated";
    }
    
}