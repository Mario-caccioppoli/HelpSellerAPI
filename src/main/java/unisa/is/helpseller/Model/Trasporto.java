package unisa.is.helpseller.Model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "trasporto")
public class Trasporto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idTrasporto;
    
    @Column
    private String indirizzoConsegna;
    
    @Column
    private int quantitaMinima;
    
    @Column
    private Date dataConsegna;
    
    @Column
    private int idOrdine;

 
    public Trasporto() {}

    public Trasporto(String indirizzoConsegna, int quantitaMinima, Date dataConsegna, int idOrdine) {
        this.indirizzoConsegna = indirizzoConsegna;
        this.quantitaMinima = quantitaMinima;
        this.dataConsegna = dataConsegna;
        this.idOrdine = idOrdine;
    }
    
    
}