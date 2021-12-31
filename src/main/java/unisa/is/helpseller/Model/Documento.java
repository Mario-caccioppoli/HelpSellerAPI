package unisa.is.helpseller.Model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int idDocumento;
    
    @Column
    private String titolo;
    
    @Column
    private String autore;
    
    @Column
    private Date date;
    
    @Column
    private int idOrdine;
    
    public Documento() {}

    public Documento(String titolo, String autore, Date date, int idOrdine) {
        this.titolo = titolo;
        this.autore = autore;
        this.date = date;
        this.idOrdine = idOrdine;
    }
    
}