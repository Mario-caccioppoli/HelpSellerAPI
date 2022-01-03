package unisa.is.helpseller.Model;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name = "documento")
public class Documento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int idDocumento;
    private String titolo;
    private String autore;
    private Date data;
    private int idOrdine;
    
    public Documento() {}

    public Documento(String titolo, String autore, Date data, int idOrdine) {
        this.titolo = titolo;
        this.autore = autore;
        this.data = data;
        this.idOrdine = idOrdine;
    }

    public long getId() {
        return id;
    }

    public int getIdDocumento() {
        return idDocumento;
    }
    

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }
    
    
}