package unisa.is.helpseller.Entity;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import unisa.is.helpseller.Model.DocumentoModel;

/**
 * Classe descrittiva dell'oggetto entity Documento
 */
@Entity
@Table(name = "documento")
public class Documento implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    public Documento(DocumentoModel d) {
        this.id = d.getId();
        this.titolo = d.getTitolo();
        this.autore = d.getAutore();
        this.data = d.getData();
        this.id_ordine = d.getIdOrdine();
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
