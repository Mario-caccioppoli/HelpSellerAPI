package unisa.is.helpseller.Entity;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name = "documento")
public class Documento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titolo;
    private String autore;
    private Date data;
    private int id_ordine;
    
    public Documento() {}

    public Documento(String titolo, String autore, Date data, int id_ordine) {
        this.titolo = titolo;
        this.autore = autore;
        this.data = data;
        this.id_ordine = id_ordine;
    }

    public int getId() {
        return id;
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
        return id_ordine;
    }

    public void setIdOrdine(int id_ordine) {
        this.id_ordine = id_ordine;
    }
    
    
}
