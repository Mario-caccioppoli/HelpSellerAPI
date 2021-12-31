package unisa.is.helpseller.Model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "recensione")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idRecensione;
    
    @Column
    private String testo;
    
    @Column
    private int voto;
    
    @Column
    private Date data;
    
    @Column
    private int idProdotto;
    
    @Column
    private int idDistributore;

   
    public Recensione() {}

    public Recensione(String testo, int voto, Date data, int idProdotto, int idDistributore) {
        this.testo = testo;
        this.voto = voto;
        this.data = data;
        this.idProdotto = idProdotto;
        this.idDistributore = idDistributore;
    }
    
    
}