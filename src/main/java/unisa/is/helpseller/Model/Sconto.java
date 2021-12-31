package unisa.is.helpseller.Model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "sconto")
public class Sconto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idSconto;
    
    @Column
    private int percentuale;
    
    @Column
    private Date dataInizio;
    
    @Column
    private Date dataFine;
    
    @Column
    private String tipo;
    
    @Column
    private int quantita;
    
    @Column
    private int idAzienda;

 
    public Sconto() {}

    public Sconto(int percentuale, Date dataInizio, Date dataFine, String tipo, int quantita, int idAzienda) {
        this.percentuale = percentuale;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
        this.quantita = quantita;
        this.idAzienda = idAzienda;
    }

}